package com.creditsuisse.stockapp.arch;

import com.creditsuisse.stockapp.arch.impl.SimpleStockServicesFactoryImpl;
import com.creditsuisse.stockapp.arch.services.SimpleStockService;

/**
 * Factory of the services in the Super Simple Stock application. 
 * 
 * As design decision, all possible external systems or high level layers in the application 
 * will access to the services through this factory.
 * 
 *
 */
public interface SimpleStockServicesFactory {
	
	/**
	 * Singleton instance of the factory SimpleStockServicesFactory.
	 */
	public SimpleStockServicesFactory INSTANCE = SimpleStockServicesFactoryImpl.getInstance();
	
	/**
	 * Gets the singleton instance of the  Service, which implements the five operations
	 * to calculate the dividend yield Stock Price and record trades 
	 * for a given stock.
	 * 
	 * @return An object of type SimpleStockService, representing a instance of the Super Simple Service
	 */
	public SimpleStockService getSimpleStockService();

}
