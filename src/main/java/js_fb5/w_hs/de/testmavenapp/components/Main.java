// Generated by the Maven Archetype Plug-in
package js_fb5.w_hs.de.testmavenapp.components;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;


public class Main extends WOComponent {
	private static final long serialVersionUID = 1L;

	public Main(WOContext context) {
		super(context);
	}
	public WOActionResults zwei() {
        ZweiteSeite nextPage = (ZweiteSeite) pageWithName(ZweiteSeite.class.getName());
        return nextPage;
	}
}
