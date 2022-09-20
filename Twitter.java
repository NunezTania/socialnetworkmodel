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
		throw new UnsupportedOperationException();
	}

	public final ArrayList<IObserver> getObservers()
	{
		throw new UnsupportedOperationException();
	}

	public final ArrayList<String> getTwits()
	{
		throw new UnsupportedOperationException();
	}

	/** 
	 This method is designed to trigger update to each subscriber
	 
	 @exception NotImplementedException
	*/
	public final void Notify()
	{
		throw new UnsupportedOperationException();
	}

	/** 
	 This method is designed to add a subscriber in the list of observers
	 
	 @param observers Observers to add to the list of observers
	 @exception NotImplementedException
	*/
	public final void Subscribe(ArrayList<IObserver> observers)
	{
		throw new UnsupportedOperationException();
	}

	/** 
	 This method is designed to remove a subscriber from the existing list of observers
	 
	 @param observer Observer to remove from the list of observers
	 @exception NotImplementedException
	*/
	public final void Unsubscribe(IObserver observer)
	{
		throw new UnsupportedOperationException();
	}

	/** 
	 This method is designed to post a twit
	 
	 @param twit Twit to post
	 @exception NotImplementedException
	*/
	public final void Post(String twit)
	{
		throw new UnsupportedOperationException();
	}

	public final String getLastTwit()
	{
		throw new UnsupportedOperationException();
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region private methods
	private boolean Exists(IObserver followerToFind)
	{
		throw new UnsupportedOperationException();
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion private methods
}
