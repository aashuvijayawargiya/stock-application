package com.creditsuisse.stockapp.backend;

import java.util.ArrayList;
import java.util.HashMap;

import com.creditsuisse.stockapp.model.Stock;
import com.creditsuisse.stockapp.model.Trade;

/**
 * Represents the store service for the Stocks and Trades. It holds in memory all 
 * the information in the  Stocks application.
 * 
 *
 */
public interface StocksEntityManager {
	
	/**
	 * Record in the Stock Entity Manager a trade represented by the object <i>trade</i>.
	 * 
	 * @param trade The trade object to record.
	 * 
	 * @return True when the operation of record a trade is successful. Other case, False.
	 * 
	 * @throws Exception A exception during the operation of record a trade.
	 */
	public boolean recordTrade(Trade trade) throws Exception;
	
	/**
	 * Gets the array list that contains all the trades.
	 * 
	 * @return The array list that contains all the trades in the Super Simple Stocks application.
	 */
	public ArrayList<Trade> getTrades();
	
	/**
	 * 
	 * @param stockSymbol
	 * @return
	 */
	public Stock getStockBySymbol(String stockSymbol);
	
	/**
	 * Gets all the stocks supported by Stocks application.
	 * 
	 * @return The hash map that contains all the stocks supported by the Super Simple Stocks application.
	 */
	public HashMap<String, Stock> getStocks();
}
