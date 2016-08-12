package org.jivesoftware.openfire.plugin.restAPI;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import org.jivesoftware.openfire.XMPPServer;
import org.jivesoftware.util.*;
import org.jivesoftware.openfire.plugin.rest.RESTServicePlugin;

public final class rest_002dapi_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n\n\n\n\n");
      out.write('\n');
      org.jivesoftware.util.WebManager admin = null;
      synchronized (_jspx_page_context) {
        admin = (org.jivesoftware.util.WebManager) _jspx_page_context.getAttribute("admin", PageContext.PAGE_SCOPE);
        if (admin == null){
          admin = new org.jivesoftware.util.WebManager();
          _jspx_page_context.setAttribute("admin", admin, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write('\n');

	admin.init(request, response, session, application, out);

      out.write('\n');
      out.write('\n');

	// Get parameters
	boolean save = request.getParameter("save") != null;
	boolean success = request.getParameter("success") != null;
	String secret = ParamUtils.getParameter(request, "secret");
	boolean enabled = ParamUtils.getBooleanParameter(request, "enabled");
	boolean httpBasicAuth = ParamUtils.getBooleanParameter(request, "authtype");
	String allowedIPs = ParamUtils.getParameter(request, "allowedIPs");

	RESTServicePlugin plugin = (RESTServicePlugin) XMPPServer.getInstance().getPluginManager()
			.getPlugin("restapi");

	// Handle a save
	Map errors = new HashMap();
	if (save) {
		if (errors.size() == 0) {
			plugin.setEnabled(enabled);
			plugin.setSecret(secret);
			plugin.setHttpBasicAuth(httpBasicAuth);
			plugin.setAllowedIPs(StringUtils.stringToCollection(allowedIPs));
			response.sendRedirect("rest-api.jsp?success=true");
			return;
		}
	}

	secret = plugin.getSecret();
	enabled = plugin.isEnabled();
	httpBasicAuth = plugin.isHttpBasicAuth();
	allowedIPs = StringUtils.collectionToString(plugin.getAllowedIPs());

      out.write("\n\n<html>\n<head>\n<title>REST API Properties</title>\n<meta name=\"pageID\" content=\"rest-api\" />\n</head>\n<body>\n\n\t<p>Use the form below to enable or disable the REST API and\n\t\tconfigure the authentication.</p>\n\n\t");

		if (success) {
	
      out.write("\n\n\t<div class=\"jive-success\">\n\t\t<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n\t\t\t<tbody>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"jive-icon\"><img src=\"images/success-16x16.gif\"\n\t\t\t\t\t\twidth=\"16\" height=\"16\" border=\"0\"></td>\n\t\t\t\t\t<td class=\"jive-icon-label\">REST API properties edited\n\t\t\t\t\t\tsuccessfully.</td>\n\t\t\t\t</tr>\n\t\t\t</tbody>\n\t\t</table>\n\t</div>\n\t<br>\n\t");

		}
	
      out.write("\n\n\t<form action=\"rest-api.jsp?save\" method=\"post\">\n\n\t\t<fieldset>\n\t\t\t<legend>REST API</legend>\n\t\t\t<div>\n\t\t\t\t<p>\n\t\t\t\t\tThe REST API can be secured with a shared secret key defined below\n\t\t\t\t\tor a with HTTP basic authentication.<br />Moreover, for extra\n\t\t\t\t\tsecurity you can specify the list of IP addresses that are allowed\n\t\t\t\t\tto use this service.<br />An empty list means that the service can\n\t\t\t\t\tbe accessed from any location. Addresses are delimited by commas.\n\t\t\t\t</p>\n\t\t\t\t<ul>\n\t\t\t\t\t<input type=\"radio\" name=\"enabled\" value=\"true\" id=\"rb01\"\n\t\t\t\t\t\t");
      out.print(((enabled) ? "checked" : ""));
      out.write(">\n\t\t\t\t\t<label for=\"rb01\"><b>Enabled</b> - REST API requests will\n\t\t\t\t\t\tbe processed.</label>\n\t\t\t\t\t<br>\n\t\t\t\t\t<input type=\"radio\" name=\"enabled\" value=\"false\" id=\"rb02\"\n\t\t\t\t\t\t");
      out.print(((!enabled) ? "checked" : ""));
      out.write(">\n\t\t\t\t\t<label for=\"rb02\"><b>Disabled</b> - REST API requests will\n\t\t\t\t\t\tbe ignored.</label>\n\t\t\t\t\t<br>\n\t\t\t\t\t<br>\n\n\t\t\t\t\t<input type=\"radio\" name=\"authtype\" value=\"true\"\n\t\t\t\t\t\tid=\"http_basic_auth\" ");
      out.print(((httpBasicAuth) ? "checked" : ""));
      out.write(">\n\t\t\t\t\t<label for=\"http_basic_auth\">HTTP basic auth - REST API\n\t\t\t\t\t\tauthentication with Openfire admin account.</label>\n\t\t\t\t\t<br>\n\t\t\t\t\t<input type=\"radio\" name=\"authtype\" value=\"false\"\n\t\t\t\t\t\tid=\"secretKeyAuth\" ");
      out.print(((!httpBasicAuth) ? "checked" : ""));
      out.write(">\n\t\t\t\t\t<label for=\"secretKeyAuth\">Secret key auth - REST API\n\t\t\t\t\t\tauthentication over specified secret key.</label>\n\t\t\t\t\t<br>\n\t\t\t\t\t<label style=\"padding-left: 25px\" for=\"text_secret\">Secret\n\t\t\t\t\t\tkey:</label>\n\t\t\t\t\t<input type=\"text\" name=\"secret\" value=\"");
      out.print(secret);
      out.write("\"\n\t\t\t\t\t\tid=\"text_secret\">\n\t\t\t\t\t<br>\n\t\t\t\t\t<br>\n\n\t\t\t\t\t<label for=\"allowedIPs\">Allowed IP Addresses:</label>\n\t\t\t\t\t<textarea name=\"allowedIPs\" cols=\"40\" rows=\"3\" wrap=\"virtual\">");
      out.print(((allowedIPs != null) ? allowedIPs : ""));
      out.write("</textarea>\n\t\t\t\t</ul>\n\n\t\t\t\t<p>You can find here detailed documentation over the Openfire REST API: \n\t\t\t\t\t<a\n\t\t\t\t\t\thref=\"/plugin-admin.jsp?plugin=restapi&showReadme=true&decorator=none\">REST\n\t\t\t\t\t\tAPI Documentation</a>\n\t\t\t\t</p>\n\t\t\t</div>\n\t\t</fieldset>\n\n\t\t<br> <br> <input type=\"submit\" value=\"Save Settings\">\n\t</form>\n\n\n</body>\n</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("admin");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.manager}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }
}
