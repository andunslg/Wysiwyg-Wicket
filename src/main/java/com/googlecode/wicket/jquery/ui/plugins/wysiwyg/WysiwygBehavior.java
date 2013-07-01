/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements. See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.googlecode.wicket.jquery.ui.plugins.wysiwyg;

import com.googlecode.wicket.jquery.core.JQueryBehavior;
import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.jquery.ui.plugins.wysiwyg.resource.*;
import com.googlecode.wicket.jquery.ui.plugins.wysiwyg.settings.IWysiwygLibrarySettings;
import org.apache.wicket.Application;
import org.apache.wicket.markup.html.IPackageResourceGuard;
import org.apache.wicket.markup.html.SecurePackageResourceGuard;
import org.apache.wicket.markup.html.SecurePackageResourceGuard.SearchPattern;

public class WysiwygBehavior extends JQueryBehavior {
	private static final long serialVersionUID = 1L;
	private static final String METHOD="wysiwyg";

	public WysiwygBehavior(String selector) {
		this(selector, new Options());
	}

	public WysiwygBehavior(String selector, Options options) {
		super(selector, METHOD, options);

		IPackageResourceGuard packageResourceGuard = Application.get().getResourceSettings().getPackageResourceGuard();
		if (packageResourceGuard instanceof SecurePackageResourceGuard) {
			SecurePackageResourceGuard guard = (SecurePackageResourceGuard) packageResourceGuard;
			if (!guard.getPattern().contains(new SearchPattern("+*.eot"))) {
				guard.addPattern("+*.eot");
				guard.addPattern("+*.woff");
				guard.addPattern("+*.ttf");
			}
		}

		this.initReferences();
	}

	private void initReferences(){
		IWysiwygLibrarySettings settings = getLibrarySettings();

//Bootstrap combined CSS
		if (settings != null && settings.getBootstrapCombinedNoIconsStyleSheetReference() != null)
		{
			this.add(settings.getBootstrapCombinedNoIconsStyleSheetReference());
		}
		else
		{
			this.add(BootstrapCombinedNoIconsStyleSheetResourceReference.get());
		}

//Bootstrap Responsive CSS
		if (settings != null && settings.getBootstrapResponsiveStyleSheetReference() != null)
		{
			this.add(settings.getBootstrapResponsiveStyleSheetReference());
		}
		else
		{
			this.add(BootstrapResponsiveStyleSheetResourceReference.get());
		}

//Font Awesome CSS
		if (settings != null && settings.getFontAwesomeStyleSheetReference() != null)
		{
			this.add(settings.getFontAwesomeStyleSheetReference());
		}
		else
		{
			this.add(FontAwesomeStyleSheetResourceReference.get());
		}

//Editor CSS
		if (settings != null && settings.getEditorStyleSheetReference() != null)
		{
			this.add(settings.getEditorStyleSheetReference());
		}
		else
		{
			this.add(EditorStyleSheetResourceReference.get());
		}

// Bootstrap Wysiwyg
		if (settings != null && settings.getBootstrapWysiwygJavaScriptReference() != null)
		{
			this.add(settings.getBootstrapWysiwygJavaScriptReference());
		}
		else
		{
			this.add(BootstrapWysiwygJavaScriptResourceReference.get());
		}

// Bootstrap
		if (settings != null && settings.getBootstrapJavaScriptReference() != null)
		{
			this.add(settings.getBootstrapJavaScriptReference());
		}
		else
		{
			this.add(BootstrapJavaScriptResourceReference.get());
		}

// JQuery Hot Keys
		if (settings != null && settings.getJqueryHotKeysJavaScriptReference() != null)
		{
			this.add(settings.getJqueryHotKeysJavaScriptReference());
		}
		else
		{
			this.add(JQueryHotKeysJavaScriptResourceReference.get());
		}

// Prettify
		if (settings != null && settings.getPrettifyJavaScriptReference() != null)
		{
			this.add(settings.getPrettifyJavaScriptReference());
		}
		else
		{
			this.add(PrettifyJavaScriptResourceReference.get());
		}
	}

	private static IWysiwygLibrarySettings getLibrarySettings()
	{
		if (Application.exists() && (Application.get().getJavaScriptLibrarySettings() instanceof IWysiwygLibrarySettings))
		{
			return (IWysiwygLibrarySettings) Application.get().getJavaScriptLibrarySettings();
		}

		return null;
	}
}