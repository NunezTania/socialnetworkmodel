package socialnetworkmodel.testsocialnetworkmodel;
import org.junit.jupiter.api.BeforeEach;
import socialnetworkmodel.*;

import java.util.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;


//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [TestFixture] public class Tests
public class Tests
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region private attributes
	private Twitter _twitter;
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion private attributes

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [SetUp] public void Setup()
	@BeforeEach
	public final void Setup()
	{
		_twitter = new Twitter();
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Test] public void Observers_AfterInstanciationWithoutObservers_Succes()
	@Test
	public final void Observers_AfterInstanciationWithoutObservers_Succes()
	{
		//when
		//refere to Setup method
		int exceptedAmountOfObservers = 0;

		//then
		//event is called directly by the assertion

		//when
		assert exceptedAmountOfObservers == _twitter.getObservers().size();

	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Test] public void Observers_AfterInstanciationWithObservers_Succes()
	@Test
	public final void Observers_AfterInstanciationWithObservers_Succes()
	{
		//when
		int exceptedAmountOfObservers = 10;
		_twitter = new Twitter(GenerateObserver(exceptedAmountOfObservers));

		//then
		//event is called directly by the assertion

		//when
		assert exceptedAmountOfObservers == _twitter.getObservers().size();
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Test] public void Twits_AfterInstanciation_Success()
	@Test
	public final void Twits_AfterInstanciation_Success()
	{
		//when
		int exceptedAmountOfTwits = 0;
		_twitter = new Twitter();

		//then
		//event is called directly by the assertion

		//when
		assert exceptedAmountOfTwits == _twitter.getTwits().size();
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Test] public void Notify_EmptyListOfSubscriber_ThrowsException()
	@Test
	public final void Notify_EmptyListOfSubscriber_ThrowsException()
	{
		//given
		//refere to Setup method

		//when
		//event is called directly by the assertion

		//then

		assertThrows(EmptyListOfSubscribersException.class, () -> _twitter.Notify());
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Test] public void Subscribe_AddFirstSubscribers_Success()
	@Test
	public final void Subscribe_AddFirstSubscribers_Success()
	{
		//given
		//refere to Setup method
		int expectedAmountOfSubscribers = 15;
		ArrayList<IObserver> followers = GenerateObserver(expectedAmountOfSubscribers);

		//when
		_twitter.Subscribe(followers);

		//then
		assert expectedAmountOfSubscribers == _twitter.getObservers().size();
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Test] public void Subscribe_AddSubscribersToExistingList_Success()
	@Test
	public final void Subscribe_AddSubscribersToExistingList_Success()
	{
		//given
		//refere to Setup method
		int expectedAmountOfSubscribers = 30;
		ArrayList<IObserver> followers = GenerateObserver(expectedAmountOfSubscribers / 2);
		_twitter.Subscribe(followers);
		ArrayList<IObserver> followers2nd = GenerateObserver(expectedAmountOfSubscribers / 2);

		//when
		_twitter.Subscribe(followers2nd);

		//then
		assert expectedAmountOfSubscribers == _twitter.getObservers().size();
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Test] public void Subscribe_SubscriberAlreadyExists_ThrowsException()
	@Test
	public final void Subscribe_SubscriberAlreadyExists_ThrowsException()
	{
		//given
		//refere to Setup method
		int expectedAmountOfSubscribers = 15;
		ArrayList<IObserver> followers = GenerateObserver(expectedAmountOfSubscribers);
		_twitter.Subscribe(followers);
		ArrayList<IObserver> followersDuplicate = new ArrayList<IObserver>(Arrays.asList(followers.get(0)));

		//when
		//event is called directly by the assertion

		//then

		assertThrows(SubscriberAlreadyExistsException.class, () -> _twitter.Subscribe(followersDuplicate));
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Test] public void Unsubscribe_NominalCase_Success()
	@Test
	public final void Unsubscribe_NominalCase_Success()
	{
		//given
		//refer to Setup method
		ArrayList<IObserver> followers = GenerateObserver(20);
		_twitter.Subscribe(followers);

		//when
		_twitter.Unsubscribe(followers.get(10));

		//then
		assert followers.size() == _twitter.getObservers().size() + 1;
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Test] public void Unsubscribe_EmptyListOfSubscriber_ThrowsException()
	@Test
	public final void Unsubscribe_EmptyListOfSubscriber_ThrowsException()
	{
		//given
		//refer to Setup method
		Follower followerToRemove = new Follower();

		//when
		//event is called directly by the assertion

		//then
		assertThrows(EmptyListOfSubscribersException.class, () -> _twitter.Unsubscribe(followerToRemove));
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Test] public void Unsubscribe_SubscriberNotFound_ThrowsException()
	@Test
	public final void Unsubscribe_SubscriberNotFound_ThrowsException()
	{
		//given
		//refere to Setup method
		IObserver followerNotFound = new Follower();
		_twitter.Subscribe(GenerateObserver(10));

		//when
		//event is called directly by the assertion

		//then
		assertThrows(SubscriberNotFoundException.class, () -> _twitter.Unsubscribe(followerNotFound));
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region private methods
	private ArrayList<IObserver> GenerateObserver(int amountOfObserverToCreate)
	{
		ArrayList<IObserver> observers = new ArrayList<IObserver>();
		for (int i = 0; i < amountOfObserverToCreate; i++)
		{
			observers.add(new Follower());
		}
		return observers;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion private methods
}
