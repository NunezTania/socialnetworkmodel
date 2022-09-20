package socialnetworkmodel;

import java.util.*;

public class Twitter implements IObservable
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region private attributes
	private ArrayList<IObserver> _observers = new ArrayList<IObserver>();
	private ArrayList<String> _twits = new ArrayList<String>();
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion private attributes

	public Twitter()
	{
	}

	public Twitter(ArrayList<IObserver> observers)
	{
		_observers = observers;
	}

	public final ArrayList<IObserver> getObservers()
	{
		return _observers;
	}

	public final ArrayList<String> getTwits()
	{
		return _twits;
	}

	/** 
	 This method is designed to trigger update to each subscriber

	*/
	public final void Notify()
	{
		for(IObserver observer : _observers)
		{
			observer.Update(this);
		}
	}

	/** 
	 This method is designed to add a subscriber in the list of observers
	 
	 @param observers Observers to add to the list of observers

	*/
	public final void Subscribe(ArrayList<IObserver> observers)
	{

		for(IObserver observer : observers)
		{
			_observers.add(observer);
		}
	}

	/** 
	 This method is designed to remove a subscriber from the existing list of observers
	 
	 @param observer Observer to remove from the list of observers
	*/
	public final void Unsubscribe(IObserver observer)
	{

		_observers.remove(observer);
	}

	/** 
	 This method is designed to post a twit
	 
	 @param twit Twit to post
	*/
	public final void Post(String twit)
	{
		_twits.add(twit);
	}

	public final String getLastTwit()
	{

		return _twits.get(_twits.size() - 1);
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region private methods
	private boolean Exists(IObserver followerToFind)
	{

		for(IObserver follower : _observers)
		{
			if (follower == followerToFind)
			{
				return true;
			}
		}
		return false;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion private methods
}
