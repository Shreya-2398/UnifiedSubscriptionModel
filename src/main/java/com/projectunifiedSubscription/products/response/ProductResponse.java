package com.projectunifiedSubscription.products.response;

import com.projectunifiedSubscription.products.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    String message;

    Product[] data;
}
