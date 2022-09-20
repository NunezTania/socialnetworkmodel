package socialnetworkmodel;

import java.util.*;

public interface IObservable
{
	//Subscribe an Observer to an Observable
	void Subscribe(ArrayList<IObserver> observer);

	//Unsubscribe an Observer from an Observable
	void Unsubscribe(IObserver observer);

	//Notify all Observers about a post, an event and any kind of updates
	void Notify();
}
