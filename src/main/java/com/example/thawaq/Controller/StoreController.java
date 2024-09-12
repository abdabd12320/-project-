package com.example.thawaq.Controller;

import com.example.thawaq.Api.ApiResponse;
import com.example.thawaq.Model.Store;
import com.example.thawaq.Service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store")
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/get")
    public ResponseEntity getStores()
    {
        return ResponseEntity.status(200).body(storeService.getStores());
    }
    @PostMapping("/add/{storeID}") //v2
    public ResponseEntity addStore(@PathVariable Integer storeID,@Valid@RequestBody Store store)
    {
        storeService.addStore(storeID,store);
        return ResponseEntity.status(200).body(new ApiResponse("Store added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStore(@PathVariable Integer id,@Valid@RequestBody Store store)
    {
        storeService.updateStore(id, store);
        return ResponseEntity.status(200).body(new ApiResponse("Store updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStore(@PathVariable Integer id)
    {
        storeService.deleteStore(id);
        return ResponseEntity.status(200).body(new ApiResponse("Store deleted"));
    }
}
