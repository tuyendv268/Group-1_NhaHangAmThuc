package com.cnpm;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;


@Service
public class PricingEngine {
  private int price = 100;
  
  public int getProductPrice() {
    return price;
    
  }
  
//  @Scheduled(fixedDelay = 2000)
  public void computePrice() throws InterruptedException {
    
    System.out.println(LocalDateTime.now());
    // added sleep to simulate method 
    // which takes longer to execute.   
    Thread.sleep(4000); 
  }

}