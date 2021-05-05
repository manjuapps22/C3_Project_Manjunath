import java.time.LocalTime;
import java.util.*;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException
    {
        //return null;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    	List<Restaurant> listOfResturants = getRestaurants();
    	
    	Iterator itr = listOfResturants.iterator();
    	
    	while(itr.hasNext())
    	{
            Restaurant restObj = (Restaurant) itr.next();
    		
    		if(restaurantName.equalsIgnoreCase(restObj.getName()))
    			return restObj;
    	}
    	
    	throw new restaurantNotFoundException(restaurantName);
    }

    public int getOrderValue(ArrayList<Item> itemsList)
    {
    	int orderValue = 0;
    	Iterator itr = itemsList.iterator();
    	
    	while(itr.hasNext())
    	{
    		Item itemObj = (Item) itr.next();
    		
    		orderValue = orderValue + itemObj.getPrice();
    	}
    	
    	return orderValue;
    }

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
