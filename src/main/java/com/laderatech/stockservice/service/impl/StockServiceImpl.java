package com.laderatech.stockservice.service.impl;

import com.laderatech.stockservice.exception.ResourceNotFoundException;
import com.laderatech.stockservice.mapper.impl.StockMapperImpl;
import com.laderatech.stockservice.model.Stock;
import com.laderatech.stockservice.repository.StockRepository;
import com.laderatech.stockservice.request.StockRequest;
import com.laderatech.stockservice.response.StockResponse;
import com.laderatech.stockservice.service.StockService;
import com.laderatech.stockservice.vo.StockVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockMapperImpl stockMapper;

    @Override
    public StockResponse addStock(StockRequest request) {

        StockResponse stockResponse = new StockResponse();
        Stock stock = stockMapper.mapToStock(request.getStockVoRequest());
        stock.setCreatedBy("admin");
        Stock savedStock=stockRepository.save(stock);
        StockVo savedStockVo=stockMapper.mapToStockVo(savedStock);
        stockResponse.setStockVoResponse(savedStockVo);
        return stockResponse;
    }

    @Override
    public StockResponse getStockById(Long id) {
        StockResponse stockResponse = new StockResponse();
        if(Objects.nonNull(id)) {
            Optional<Stock> stock = stockRepository.findById(id);
            if(Optional.empty().isPresent()){
               StockVo stockvo= stockMapper.mapToStockVo(stock.get());
               stockResponse.setStockVoResponse(stockvo);
               return stockResponse;
            }
        }
        stockResponse.setStockVoResponse(null);
        return stockResponse;
        }
        // .orElseThrow(() -> new ResourceNotFoundException("Stock","id",id));

    @Override
    public StockResponse findAllStocks() {
        StockResponse stockResponse = new StockResponse();
        List<Stock> stockList = stockRepository.findAll();
        stockResponse.setStockVoResponseList(stockMapper.mapToStockVoList(stockList));
        return stockResponse;
    }

    @Override
    public StockResponse updateStock(StockRequest request) {
        StockResponse stockResponse = new StockResponse();

       /* Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock","id",id));

        stock.setProductCode(request.getStockVoRequest().getProductCode());
        stock.setProductQuantity(request.getStockVoRequest().getProductQuantity());
        stock.setLocation(request.getStockVoRequest().getLocation());
        stock.setZipCode(request.getStockVoRequest().getZipCode());
        stock.setUpdatedBy("admin");
*/
        Stock stock = stockMapper.mapToStock(request.getStockVoRequest());
        Stock updatedStock = stockRepository.save(stock);
        StockVo stockVo = stockMapper.mapToStockVo(updatedStock);
        stockResponse.setStockVoResponse(stockVo);

        return stockResponse;

    }

    @Override
    public void deleteStockById(long id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock","id",id));

        stockRepository.delete(stock);
    }


}
