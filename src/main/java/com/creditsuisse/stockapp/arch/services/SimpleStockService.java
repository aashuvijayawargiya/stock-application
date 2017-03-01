package com.creditsuisse.stockapp.arch.services;

import com.creditsuisse.stockapp.model.Trade;

/**
 * Super Simple Service, which implements the five operations to calculate the dividend yield, 
 * P/E Ratio, Stock Price, GBCE All Share Index and record trades for a given stock.
 * 
 
 *
 */
public interface SimpleStockService {
	
	/**
	 * Calculates the dividend yield for a given stock.
	 * 
	 * @param stockSymbol Stock symbol.
	 * 
	 * @return A double value which represents the dividend yield for a given stock.
	 * 
	 * @throws Exception A exception raised during the execution of the method due to an error.
	 */
	public double calculateDividendYield(String stockSymbol) throws Exception;
	
	
	/**
	 * Record a trade in the Super Simple Stocks application.
	 * 
	 * @param trade Trade object to record.
	 * 
	 * @return True, when the record is successful. Other case, False.
	 */
	public boolean recordTrade(Trade trade) throws Exception;
	
	/**
	 * 
	 * @param stockSymbol
	 * @return
	 * @throws Exception
	 */
	public double calculateStockPrice(String stockSymbol) throws Exception;
	
}
