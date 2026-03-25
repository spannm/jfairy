package com.devskiller.jfairy.data;

import java.util.List;

import com.devskiller.jfairy.producer.util.LanguageCode;

/**
 * Providing access to localized data used by producers.
 * <p>
 * This master component acts as the central registry for retrieving
 * strings and structured data based on specific keys and language codes.
 *
 * @author Olga Maciaszek-Sharma
 * @since 23.04.15
 */
public interface DataMaster {

	/**
	 * Returns a single string value associated with the given key.
	 *
	 * @param key the unique identifier for the data entry
	 * @return the string value found for the key
	 */
	String getString(String key);

	/**
	 * Returns a list of strings associated with the given key.
	 *
	 * @param key the unique identifier for the data entries
	 * @return a list of string values found for the key
	 */
	List<String> getStringList(String key);

	/**
	 * Retrieves structured data of a specific type and converts it to the requested class.
	 *
	 * @param dataKey the root key for the data search
	 * @param type the specific sub-type or category
	 * @param resultClass the class type to which the result should be cast
	 * @param <T> the type of the result object
	 * @return an instance of the requested type containing the values
	 */
	<T> T getValuesOfType(String dataKey, String type, Class<T> resultClass);

	/**
	 * Selects a random string value from the entries associated with the given key.
	 *
	 * @param key the unique identifier for the data list
	 * @return a randomly selected string value
	 */
	String getRandomValue(String key);

	/**
	 * Returns the language code currently used by this data master.
	 *
	 * @return the active LanguageCode
	 */
	LanguageCode getLanguage();

}
