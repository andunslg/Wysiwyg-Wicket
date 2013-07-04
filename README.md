Wysiwyg-Wicket
==============

* Wysiwyg-Wicket plugin based on http://mindmup.github.io/bootstrap-wysiwyg/ and Wicket-Jquery-Ui

* This plugin is using the Silk Icons set Developed by Mark James which is licensed under
  Creative Commons Attribution 2.5 License. Link http://www.famfamfam.com/lab/icons/silk/

* Using this plugin, you can add Wysiwyg Rich Text Editor to your Wicket Application

* This supports adding configurable Toolbar with localizations

* Following example describes how to use Wysiwyg-Wicket editor with its default toolbar and localization options

----Html----

<html lang="en">
<!--Markup-->
<body>

<form wicket:id="form">
    <div wicket:id="languages">
        <a href="#" wicket:id="english">English</a>&#160;
        <a href="#" wicket:id="russian">Russian</a>&#160;
        <a href="#" wicket:id="french">French</a>&#160;
        <a href="#" wicket:id="spanish">Spanish</a>&#160;
    </div>
    <div wicket:id="toolbarContainer">
    </div>
    <div wicket:id="editorContainer">
    </div>
    <br>
    <input type="submit" value="Click me to submit the form" wicket:id="submitBtn" onclick=""/>
</form>

</body>
</html>

----Java----

package com.googlecode.wicket.jquery.ui.plugins.wysiwyg.sample;

import com.googlecode.wicket.jquery.ui.plugins.wysiwyg.WysiwygEditor;
import com.googlecode.wicket.jquery.ui.plugins.wysiwyg.toolbar.DefaultWysiwygToolbar;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.Locale;


public class Editor extends WebPage{
	private static final long serialVersionUID=1L;
	String value="Type";
	WysiwygEditor wysiwygEditor;
	DefaultWysiwygToolbar wysiwygDefaultToolbar;

	public Editor(PageParameters parameters){

		super(parameters);

		Form form=new Form("form");

		AjaxButton submit=new AjaxButton("submitBtn"){
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form){
				System.out.println(wysiwygEditor.getModelObject());
			}

		} ;

		form.add(submit);

		WebMarkupContainer langs=new WebMarkupContainer("languages");

		langs.add(new Link("english")
		{
			@Override
			public void onClick()
			{
				getSession().setLocale(new Locale("english"));
			}
		});
		langs.add(new Link("russian")
		{
			@Override
			public void onClick()
			{
				getSession().setLocale(new Locale("russian"));
			}
		});
		langs.add(new Link("spanish")
		{
			@Override
			public void onClick()
			{
				getSession().setLocale(new Locale("spanish"));
			}
		});
		langs.add(new Link("french")
		{
			@Override
			public void onClick()
			{
				getSession().setLocale(new Locale("french"));
			}
		});

		form.add(langs);

		wysiwygDefaultToolbar=new DefaultWysiwygToolbar("toolbarContainer");
		form.add(wysiwygDefaultToolbar);
		wysiwygEditor=new WysiwygEditor("editorContainer",new Model<String>(value),wysiwygDefaultToolbar);
		form.add(wysiwygEditor);
		this.add(form);

	}
}

