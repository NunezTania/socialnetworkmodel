package socialnetworkmodel;

public class Follower implements IObserver
{
	//Receive update from the observable
	public final void Update(IObservable observable)
	{
		Twitter twitter = (Twitter)observable;
		for (String twit : twitter.getTwits())
		{
			System.out.println(twit);
		}
	}
}
