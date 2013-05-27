package com.googlecode.wicket.jquery.ui.plugins.wysiwyg;

import com.googlecode.wicket.jquery.core.JQueryBehavior;
import com.googlecode.wicket.jquery.core.Options;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class WysiwygBehavior extends JQueryBehavior{
	private static final JavaScriptResourceReference JS1=new JavaScriptResourceReference(WysiwygBehavior.class,"bootstrap-wysiwyg.js");
	private static final JavaScriptResourceReference JS2=new JavaScriptResourceReference(WysiwygBehavior.class,"bootstrap.min.js");
	private static final JavaScriptResourceReference JS3=new JavaScriptResourceReference(WysiwygBehavior.class,"jquery.hotkeys.js");
	private static final JavaScriptResourceReference JS4=new JavaScriptResourceReference(WysiwygBehavior.class,"prettify.js");
	private static final CssResourceReference CSS1=new CssResourceReference(WysiwygBehavior.class,"bootstrap-combined.no-icons.min.css");
	private static final CssResourceReference CSS2=new CssResourceReference(WysiwygBehavior.class,"bootstrap-responsive.min.css");
	private static final CssResourceReference CSS3=new CssResourceReference(WysiwygBehavior.class,"font-awesome.css");

	public WysiwygBehavior(String selector, String method){
		super(selector,method);
		this.add(JS1);
		this.add(JS2);
		this.add(JS3);
		this.add(JS4);
		this.add(CSS1);
		this.add(CSS2);
		this.add(CSS3);
	}

	public WysiwygBehavior(String selector, String method, Options options){
		super(selector,method,options);
		this.add(JS1);
		this.add(JS2);
		this.add(JS3);
		this.add(JS4);
		this.add(CSS1);
		this.add(CSS2);
		this.add(CSS3);
	}
}
