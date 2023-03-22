package com.laderatech.stockservice.request;

import com.laderatech.stockservice.model.Stock;
import com.laderatech.stockservice.vo.StockVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockRequest {

    private StockVo stockVoRequest;
    //private Stock stockRequest;
}
