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
		_observers.addAll(observers);
	}

	public final ArrayList<IObserver> getObservers() { return new ArrayList<>(_observers); }

	public final ArrayList<String> getTwits()
	{
		return new ArrayList<>(_twits);
	}

	/** 
	 This method is designed to trigger update to each subscriber
	*/
	public final void Notify()
	{
		if (_observers.isEmpty())
			throw new EmptyListOfSubscribersException();
		for (IObserver observer : _observers)
		{
			observer.Update(this);
		}
	}

	/** 
	 This method is designed to add a subscriber in the list of observers
	 
	 @param observers Observers to add to the list of observers
	 @exception SubscriberAlreadyExistsException
	*/
	public final void Subscribe(ArrayList<IObserver> observers)
	{
		if (observers != null)
		{
			if (observers.size() > 0)
			{
				for (IObserver observer : observers)
				{
					if (_observers.contains(observer))
						throw new SubscriberAlreadyExistsException();
					_observers.add(observer);
				}
			}
		}
	}

	/** 
	 This method is designed to remove a subscriber from the existing list of observers
	 
	 @param observer Observer to remove from the list of observers
	*/
	public final void Unsubscribe(IObserver observer)
	{
		if (_observers.size() == 0)
			throw new EmptyListOfSubscribersException();
		if (!_observers.contains(observer))
			throw new SubscriberNotFoundException();
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
		if (_observers.isEmpty())
			throw new EmptyListOfSubscribersException();
		return _observers.contains(followerToFind);
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion private methods
}
