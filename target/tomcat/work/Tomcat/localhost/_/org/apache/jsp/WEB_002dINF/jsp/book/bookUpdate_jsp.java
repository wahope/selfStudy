/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-04-12 00:12:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class bookUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<title>文章列表--layui后台管理模板 2.0</title>\n");
      out.write("\t<meta name=\"renderer\" content=\"webkit\">\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("\t<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\n");
      out.write("\t<meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\n");
      out.write("\t<meta name=\"format-detection\" content=\"telephone=no\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"/layui/css/layui.css\" media=\"all\" />\n");
      out.write("\t<link rel=\"stylesheet\" href=\"/css/public.css\" media=\"all\" />\n");
      out.write("\t<style type=\"text/css\">\n");
      out.write("\t\t.layui-col-space10{\n");
      out.write("\t\t\tmargin-left:2.5em;\n");
      out.write("\t\t}\n");
      out.write("\t\t.layui-form-item magt3{\n");
      out.write("\t\t\twidth: auto;\n");
      out.write("\t\t}\n");
      out.write("\t\t.layui-form-label{\n");
      out.write("\t\t\twidth: 120px;\n");
      out.write("\t\t\ttext-align: center;\n");
      out.write("\t\t}\n");
      out.write("\t\t.layui-input-block{\n");
      out.write("\t\t\tmargin-left: 13em;\n");
      out.write("\t\t\twidth: 34em;\n");
      out.write("\t\t}\n");
      out.write("\t</style>\n");
      out.write("</head>\n");
      out.write("<body class=\"childrenBody\">\n");
      out.write("<form class=\"layui-form layui-row layui-col-space10\">\n");
      out.write("\t<div class=\"layui-col-md9 layui-col-xs12\">\n");
      out.write("\t\t<div class=\"layui-row layui-col-space10\">\n");
      out.write("\t\t\t<div class=\"layui-form-item magt3\">\n");
      out.write("\t\t\t\t<div class=\"layui-form-item magt3\">\n");
      out.write("\t\t\t\t\t<label class=\"layui-form-label\">ID</label>\n");
      out.write("\t\t\t\t\t<div class=\"layui-input-block\">\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"layui-input id\" lay-verify=\"id\" disabled>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\" style=\"margin-right: 33px;\">阶段Id</label>\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t\t<select name=\"specialty\" id=\"specialty\" lay-filter=\"specialty\" >\n");
      out.write("\t\t\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t\t\t<option></option>\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"layui-input-inline\">\n");
      out.write("\t\t\t\t\t<select name=\"state\" id=\"stage\" lay-filter=\"stage\">\n");
      out.write("\t\t\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t\t\t<option></option>\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"layui-form-item magt3\">\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">书籍名称</label>\n");
      out.write("\t\t\t\t<div class=\"layui-input-block\">\n");
      out.write("\t\t\t\t\t<input type=\"text\" class=\"layui-input bookName\" lay-verify=\"bookName\" placeholder=\"请输入资料标题\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"layui-form-item magt3\">\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">作者</label>\n");
      out.write("\t\t\t\t<div class=\"layui-input-block\">\n");
      out.write("\t\t\t\t\t<input type=\"text\" class=\"layui-input author\" lay-verify=\"author\" placeholder=\"请输入资料标题\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"layui-form-item magt3\">\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">出版社</label>\n");
      out.write("\t\t\t\t<div class=\"layui-input-block\">\n");
      out.write("\t\t\t\t\t<input type=\"text\" class=\"layui-input press\" lay-verify=\"press\" placeholder=\"请输入资料标题\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"layui-form-item magt3\">\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">购买链接</label>\n");
      out.write("\t\t\t\t<div class=\"layui-input-block\">\n");
      out.write("\t\t\t\t\t<input type=\"url\" class=\"layui-input bookUrl\" lay-verify=\"bookUrl\" placeholder=\"请输入资料标题\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"layui-form-item magt3\">\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">书籍简介</label>\n");
      out.write("\t\t\t\t<div class=\"layui-input-block\">\n");
      out.write("\t\t\t\t\t<input type=\"text\" class=\"layui-input bookIntro\" lay-verify=\"bookIntro\" placeholder=\"请输入资料标题\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"layui-form-item magt3\">\n");
      out.write("\t\t\t\t<label class=\"layui-form-label\">备注</label>\n");
      out.write("\t\t\t\t<div class=\"layui-input-block\">\n");
      out.write("\t\t\t\t\t<input type=\"text\" class=\"layui-input remark\" lay-verify=\"remark\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div class=\"layui-right\">\n");
      out.write("\t\t\t<a class=\"layui-btn layui-btn-sm\" lay-filter=\"updateNews\" lay-submit><i class=\"layui-icon\">&#xe609;</i>修改</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t</div>\n");
      out.write("</form>\n");
      out.write("<script type=\"text/javascript\" src=\"/layui/layui.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"/js/book/bookList.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"/js/book/bookUpdate.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
