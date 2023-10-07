package Java8Features;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashonDemo {

	public static void main(String[] args) throws ScriptException, FileNotFoundException, NoSuchMethodException {

		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		// engine.eval("print('hello world');");
		engine.eval(new FileReader("resources/hello.js"));

		// passing a param as a variable

		//Bindings bind = engine.getBindings(ScriptContext.ENGINE_SCOPE);

		//bind.put("msg", "calling js message");
		engine.eval(new FileReader("resources/hello2.js"));
		
		//call function from js file//Invocable is interface
		Invocable invocable=(Invocable)engine;
		invocable.invokeFunction("show1");
		invocable.invokeFunction("show2","java");
		invocable.invokeFunction("show1","java","1.8");
		
		
	}

}
