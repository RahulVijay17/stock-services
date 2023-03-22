package com.laderatech.stockservice.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.laderatech.stockservice.model.Stock;
import com.laderatech.stockservice.vo.StockVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockResponse {

    private StockVo stockVoResponse;
    private List<StockVo> stockVoResponseList;
   // private Stock stockResponse;

}
