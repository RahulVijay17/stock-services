package com.laderatech.stockservice.controller;

import com.laderatech.stockservice.request.StockRequest;
import com.laderatech.stockservice.response.StockResponse;
import com.laderatech.stockservice.service.StockService;
import com.laderatech.stockservice.vo.StockVo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/stock")
public class StockController {

    private StockService stockService;

    @PostMapping
    private ResponseEntity<StockResponse> createStock(@RequestBody StockRequest request){
        StockResponse response= stockService.addStock(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    private ResponseEntity<StockResponse> getStockById(@PathVariable("id") Long id){
        return ResponseEntity.ok(stockService.getStockById(id));
    }

    @GetMapping
    private ResponseEntity<StockResponse> findAllStocks(){
        return new ResponseEntity<>(stockService.findAllStocks(),HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<StockResponse> updatedStock(@RequestBody StockRequest request){
       StockResponse stockResponse = stockService.updateStock(request);

        return new ResponseEntity<>(stockResponse,HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    private ResponseEntity<String> deleteStock(@PathVariable("id") Long id){
        stockService.deleteStockById(id);
        return new ResponseEntity<>("Stock Deleted Successfully",HttpStatus.OK);
    }

}
