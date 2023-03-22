package com.laderatech.stockservice.service;

import com.laderatech.stockservice.request.StockRequest;
import com.laderatech.stockservice.response.StockResponse;
import com.laderatech.stockservice.vo.StockVo;

import java.util.List;

public interface StockService {

    StockResponse addStock(StockRequest request);

    StockResponse getStockById(Long id);

    StockResponse findAllStocks();

    StockResponse updateStock(StockRequest request);

    void deleteStockById(long id);

}
