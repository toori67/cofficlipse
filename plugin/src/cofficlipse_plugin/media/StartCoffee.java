package cofficlipse_plugin.media;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class StartCoffee extends AbstractHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		PlayCoffee.COFFEE3.letsPlay();
		return null;
	}

}
