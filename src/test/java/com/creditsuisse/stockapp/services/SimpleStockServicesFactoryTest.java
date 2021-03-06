package com.creditsuisse.stockapp.services;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.creditsuisse.stockapp.arch.SimpleStockServicesFactory;
import com.creditsuisse.stockapp.arch.SpringService;
import com.creditsuisse.stockapp.arch.services.SimpleStockService;
import com.creditsuisse.stockapp.backend.StocksEntityManager;
import com.creditsuisse.stockapp.model.Trade;


public class SimpleStockServicesFactoryTest {

	/**
	 * 
	 */
	Logger logger = Logger.getLogger(SimpleStockServicesFactoryTest.class);

	/**
	 * 
	 */
	@Test
	public void isStockServicesFactoryASingleton(){

		logger.info("Start  isStockServicesFactoryASingleton ...");

		SimpleStockServicesFactory factoryInstanceA = SimpleStockServicesFactory.INSTANCE;
		SimpleStockServicesFactory factoryInstanceB = SimpleStockServicesFactory.INSTANCE;

		Assert.assertNotNull(factoryInstanceA);
		Assert.assertNotNull(factoryInstanceB);

		Assert.assertTrue(factoryInstanceA.equals(factoryInstanceB));

		logger.info("Finish isStockServicesFactoryASingleton ...OK");

	}

	/**
	 * 
	 */
	@Test
	public void isStockServicesASingleton(){

		logger.info("Start  isStockServicesASingleton ...");

		SimpleStockServicesFactory factoryInstance = SimpleStockServicesFactory.INSTANCE;

		SimpleStockService simpleStockServiceA = factoryInstance.getSimpleStockService();
		SimpleStockService simpleStockServiceB = factoryInstance.getSimpleStockService();

		Assert.assertNotNull(simpleStockServiceA);
		Assert.assertNotNull(simpleStockServiceB);

		Assert.assertTrue(simpleStockServiceA.equals(simpleStockServiceB));

		logger.info("Finish isStockServicesASingleton ...OK");

	}

	/**
	 * 
	 */
	@Test
	public void recordATradeTest(){
		logger.info("Start  recordATradeTest ...");

		// Create the stock service and verify it's not null object
		SimpleStockService simpleStockService = SimpleStockServicesFactory.INSTANCE.getSimpleStockService();
		Assert.assertNotNull(simpleStockService);

		// Recover the trades configured in spring for the unit test
		@SuppressWarnings("unchecked")
		ArrayList<Trade> tradeList = SpringService.INSTANCE.getBean("tradeList", ArrayList.class);
		Assert.assertNotNull(tradeList);
		logger.info("Trade List size: "+tradeList.size());


		try{
			// Initial trades are empty, means, trades number equls to cero (0)
			StocksEntityManager stocksEntityManager = SpringService.INSTANCE.getBean("stocksEntityManager", StocksEntityManager.class);
			int tradesNumber = stocksEntityManager.getTrades().size();
			logger.info("Trades number: "+tradesNumber);
			Assert.assertEquals(tradesNumber, 0);

			// Insert many trades in the stock system
			for(Trade trade: tradeList){
				boolean result = simpleStockService.recordTrade(trade);
				Assert.assertTrue(result);
			}

			// After record trades, the number of trades should be equal to the trades list
			tradesNumber = stocksEntityManager.getTrades().size();
			logger.info("Trades number: "+tradesNumber);
			Assert.assertEquals(tradesNumber, tradeList.size());


		}catch(Exception exception){
			logger.error(exception);
			Assert.assertTrue(false);
		}

		logger.info("Finish recordATradeTest ...OK");

	}	
	
	@Test
	public void calculateStockPriceTest(){
		try{
			// Create the stock service and verify it's not null object
			SimpleStockService simpleStockService = SimpleStockServicesFactory.INSTANCE.getSimpleStockService();
			Assert.assertNotNull(simpleStockService);

			StocksEntityManager stocksEntityManager = SpringService.INSTANCE.getBean("stocksEntityManager", StocksEntityManager.class);
			int tradesNumber = stocksEntityManager.getTrades().size();
			logger.info("Trades number: "+tradesNumber);
			
			// Calculates the Stock Price for all stocks
			String[] stockSymbols = {"TEA", "POP", "ALE", "GIN", "JOE"};
			//String[] stockSymbols = {"TEA"};
			for(String stockSymbol: stockSymbols){
				double stockPrice = simpleStockService.calculateStockPrice(stockSymbol);
				logger.info(stockSymbol+" - Stock Price calculated: "+stockPrice);
				Assert.assertTrue(stockPrice >= 0.0);
			}

			
		}catch(Exception exception){
			logger.error(exception);
			Assert.assertTrue(false);
		}

	}

}
