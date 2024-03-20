package page;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;

public class ElementProxy implements InvocationHandler {

	private final WebElement element;

	public ElementProxy(WebElement element) {
		this.element = element;
	}

	// @Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// before calling actual webelement invoke the below code
		this.waitAjaxLoadMethod();
		Object result = method.invoke(element, args);
		return result;
	}

	private void waitAjaxLoadMethod() {

		System.out.println("WaitAjax loaded called!");

	}

}
