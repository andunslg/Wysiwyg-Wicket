/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.wicket.jquery.ui.plugins.wysiwyg.toolbar;

import com.googlecode.wicket.jquery.core.IJQueryWidget.JQueryWidget;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.resource.PackageResourceReference;

import java.util.Locale;

/**
 * Provides a default {@link IWysiwygToolbar}
 *
 * @author sebfz1
 * @author solomax
 * @author andunslg
 */
public class DefaultWysiwygToolbar extends Panel implements IWysiwygToolbar
{
	private static final long serialVersionUID = 1L;
	private final WebMarkupContainer toolbar;

	/**
	 * Constructor
	 *
	 * @param id the markup-id
	 */
	public DefaultWysiwygToolbar(String id)
	{
		this(id, null);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup-id
	 * @param model the {@link org.apache.wicket.model.IModel}
	 */
	public DefaultWysiwygToolbar(String id, IModel<String> model)
	{
		super(id, model);

		getSession().setLocale(new Locale("english"));

		this.toolbar = new WebMarkupContainer("toolbar");
		this.toolbar.setMarkupId("bToolbar");

		//Adding Buttons with localizations
		ExternalLink fontSize= new ExternalLink("fontSize","#");
		fontSize.add(AttributeModifier.replace("title",new ResourceModel("fontSize")));
		fontSize.add(new Image("fontSizeImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"font.png")));
		toolbar.add(fontSize);

		ExternalLink bold= new ExternalLink("bold","#");
		ExternalLink italic= new ExternalLink("italic","#");
		ExternalLink strikethrough= new ExternalLink("strikethrough","#");
		ExternalLink underline= new ExternalLink("underline","#");

		bold.add(AttributeModifier.replace("title",new ResourceModel("bold")));
		italic.add(AttributeModifier.replace("title",new ResourceModel("italic")));
		strikethrough.add(AttributeModifier.replace("title",new ResourceModel("strikethrough")));
		underline.add(AttributeModifier.replace("title",new ResourceModel("underline")));

		bold.add(new Image("boldImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"text_bold.png")));
		toolbar.add(bold);
		italic.add(new Image("italicImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"text_italic.png")));
		toolbar.add(italic);
		strikethrough.add(new Image("strikethroughImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"text_strikethrough.png")));
		toolbar.add(strikethrough);
		underline.add(new Image("underlineImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"text_underline.png")));
		toolbar.add(underline);

		ExternalLink bullets= new ExternalLink("bullets","#");
		ExternalLink numbers= new ExternalLink("numbers","#");
		ExternalLink indent= new ExternalLink("indent","#");
		ExternalLink reduceIndent= new ExternalLink("reduceIndent","#");

		bullets.add(AttributeModifier.replace("title",new ResourceModel("bullets")));
		numbers.add(AttributeModifier.replace("title",new ResourceModel("numbers")));
		indent.add(AttributeModifier.replace("title",new ResourceModel("indent")));
		reduceIndent.add(AttributeModifier.replace("title",new ResourceModel("reduceIndent")));

		bullets.add(new Image("bulletsImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"text_list_bullets.png")));
		toolbar.add(bullets);
		numbers.add(new Image("numbersImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"text_list_numbers.png")));
		toolbar.add(numbers);
		indent.add(new Image("indentImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"text_indent.png")));
		toolbar.add(indent);
		reduceIndent.add(new Image("reduceIndentImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"text_indent_remove.png")));
		toolbar.add(reduceIndent);

		ExternalLink justifyLeft= new ExternalLink("justifyLeft","#");
		ExternalLink justifyCenter= new ExternalLink("justifyCenter","#");
		ExternalLink justifyRight= new ExternalLink("justifyRight","#");
		ExternalLink justifyFull= new ExternalLink("justifyFull","#");

		justifyLeft.add(AttributeModifier.replace("title",new ResourceModel("justifyLeft")));
		justifyCenter.add(AttributeModifier.replace("title",new ResourceModel("justifyCenter")));
		justifyRight.add(AttributeModifier.replace("title",new ResourceModel("justifyRight")));
		justifyFull.add(AttributeModifier.replace("title",new ResourceModel("justifyFull")));

		justifyLeft.add(new Image("justifyLeftImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"text_align_left.png")));
		toolbar.add(justifyLeft);
		justifyCenter.add(new Image("justifyCenterImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"text_align_center.png")));
		toolbar.add(justifyCenter);
		justifyRight.add(new Image("justifyRightImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"text_align_right.png")));
		toolbar.add(justifyRight);
		justifyFull.add(new Image("justifyFullImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"text_align_justify.png")));
		toolbar.add(justifyFull);

		ExternalLink hyperlink= new ExternalLink("hyperlink","#");
		ExternalLink removeHyperlink= new ExternalLink("removeHyperlink","#");

		hyperlink.add(AttributeModifier.replace("title",new ResourceModel("hyperlink")));
		removeHyperlink.add(AttributeModifier.replace("title",new ResourceModel("removeHyperlink")));

		hyperlink.add(new Image("hyperlinkImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"link.png")));
		toolbar.add(hyperlink);
		removeHyperlink.add(new Image("removeHyperlinkImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"link_delete.png")));
		toolbar.add(removeHyperlink);

		ExternalLink undo= new ExternalLink("undo","#");
		ExternalLink redo= new ExternalLink("redo","#");

		undo.add(AttributeModifier.replace("title",new ResourceModel("undo")));
		redo.add(AttributeModifier.replace("title",new ResourceModel("redo")));

		undo.add(new Image("undoImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"arrow_undo.png")));
		toolbar.add(undo);
		redo.add(new Image("redoImg",new PackageResourceReference(DefaultWysiwygToolbar.class,"arrow_redo.png")));
		toolbar.add(redo);

		this.add(this.toolbar);
	}

	@Override
	public void attachToEditor(Component editor)
	{
		this.toolbar.add(AttributeModifier.replace("data-target", JQueryWidget.getSelector(editor)));
	}
}

