package page;

import java.lang.reflect.Proxy;

import org.openqa.selenium.WebElement;

public class ElementGuard {
	public static WebElement guard(WebElement element) {
		ElementProxy proxy = new ElementProxy(element);
		WebElement wrappdElement = (WebElement) Proxy.newProxyInstance(ElementProxy.class.getClassLoader(),
				new Class[] { WebElement.class }, proxy);
		return wrappdElement;
	}

}
