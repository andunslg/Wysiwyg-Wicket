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
package com.googlecode.wicket.jquery.ui.plugins.wysiwyg;

import com.googlecode.wicket.jquery.core.JQueryBehavior;
import com.googlecode.wicket.jquery.core.Options;
import org.apache.wicket.Application;
import org.apache.wicket.markup.html.IPackageResourceGuard;
import org.apache.wicket.markup.html.SecurePackageResourceGuard;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class WysiwygBehavior extends JQueryBehavior{
	private static final JavaScriptResourceReference JS1=new JavaScriptResourceReference(WysiwygBehavior.class,"js/bootstrap-wysiwyg.js");
	private static final JavaScriptResourceReference JS2=new JavaScriptResourceReference(WysiwygBehavior.class,"js/bootstrap.min.js");
	private static final JavaScriptResourceReference JS3=new JavaScriptResourceReference(WysiwygBehavior.class,"js/jquery.hotkeys.js");
	private static final JavaScriptResourceReference JS4=new JavaScriptResourceReference(WysiwygBehavior.class,"js/prettify.js");
	private static final CssResourceReference CSS1=new CssResourceReference(WysiwygBehavior.class,"css/bootstrap-combined.no-icons.min.css");
	private static final CssResourceReference CSS2=new CssResourceReference(WysiwygBehavior.class,"css/bootstrap-responsive.min.css");
	private static final CssResourceReference CSS3=new CssResourceReference(WysiwygBehavior.class,"css/font-awesome.css");

	public WysiwygBehavior(String selector, String method){
		this(selector,method,new Options());
	}

	public WysiwygBehavior(String selector, String method, Options options){
		super(selector,method,options);

		IPackageResourceGuard packageResourceGuard=
				Application.get().getResourceSettings().getPackageResourceGuard();
		if(packageResourceGuard instanceof SecurePackageResourceGuard){
			SecurePackageResourceGuard guard=(SecurePackageResourceGuard)packageResourceGuard;
			guard.addPattern("+*.eot");
			guard.addPattern("+*.woff");
			guard.addPattern("+*.ttf");
		}

		this.add(CSS1);
		this.add(CSS2);
		this.add(CSS3);
		this.add(JS1);
		this.add(JS2);
		this.add(JS3);
		this.add(JS4);
	}
}
