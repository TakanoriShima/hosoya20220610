package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import actions.views.UserView;
import constants.AttributeConst;
import constants.ForwardConst;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String contextPath = ((HttpServletRequest) request).getContextPath();
		String servletPath = ((HttpServletRequest) request).getServletPath();
		System.out.println("contextPath= " + contextPath);
		System.out.println("servletPath= " + servletPath);

		if (servletPath.matches("/css.*")) {
			//cssフォルダ内は認証処理から除外
			chain.doFilter(request, response);
		} else {
			HttpSession session = ((HttpServletRequest) request).getSession();

			//クエリパラメータからactionとcommandを取得
			String action = request.getParameter(ForwardConst.ACT.getValue());
			String command = request.getParameter(ForwardConst.CMD.getValue());

			System.out.println("action= " + action);
			System.out.println("command= " + command);
			//セッションからログインしているユーザーの情報を取得
			UserView ev = (UserView) session.getAttribute(AttributeConst.LOGIN_US.getValue());

			if (ev == null) {
				//未ログインなら
				//↓ユーザー登録なら～の例外を追加する？
				// ログインしていない理由だけで、ログイン画面へのリダイレクトは避けて欲しい条件
				// action=null && command=null
				// action="Auth" && command=showLogin
				// command="login"
				// action="User" && command="entryNew"
				// action="User" && command="create"
				//
				if (!(ForwardConst.ACT_AUTH.getValue().equals(action)
						&& ForwardConst.CMD_SHOW_LOGIN.getValue().equals(command)
						|| ForwardConst.CMD_LOGIN.getValue().equals(command)
						|| ForwardConst.ACT_USER.getValue().equals(action)
								&& ForwardConst.CMD_NEW.getValue().equals(command)
						|| ForwardConst.ACT_USER.getValue().equals(action)
								&& ForwardConst.CMD_CREATE.getValue().equals(command)
						|| "Shop".equals(action))) {
					//ログインページの表示またはログイン実行以外はログインページにリダイレクト
					((HttpServletResponse) response).sendRedirect(
							contextPath
									+ "?action=" + ForwardConst.ACT_AUTH.getValue()
									+ "&command=" + ForwardConst.CMD_SHOW_LOGIN.getValue());
					return;
				}

			} else {
				//ログイン済
				//↓ここら辺も追加する…？承認系を行うもしくはuser＆new＆create類をやろうとすると？？
				if (ForwardConst.ACT_AUTH.getValue().equals(action)) {
					//承認系actionを行おうとしている場合

					if (ForwardConst.CMD_SHOW_LOGIN.getValue().equals(command)) {
						//ログインページの表示はトップ画面にリダイレクト
						((HttpServletResponse) response).sendRedirect(
								contextPath
										+ "?action=" + ForwardConst.ACT_TOP.getValue()
										+ "&command=" + ForwardConst.CMD_INDEX.getValue());
						return;
					} else if (ForwardConst.CMD_LOGOUT.getValue().equals(command)) {
						//ログアウトの実施は許可
					} else {
						//上記以外の承認系Actionはエラー画面
						String forward = String.format("/WEB-INF/views/%s.jsp", "error/unknown");
						RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
						dispatcher.forward(request, response);
						return;
					}
				}
			}

			//次のフィルタまたはサーブレットを呼び
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}