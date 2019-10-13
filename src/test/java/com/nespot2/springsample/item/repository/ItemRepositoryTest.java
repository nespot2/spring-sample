package com.nespot2.springsample.item.repository;

import com.nespot2.springsample.SpringSampleApplication;
import com.nespot2.springsample.common.domain.YesNo;
import com.nespot2.springsample.item.domain.Item;
import com.nespot2.springsample.item.domain.ItemCategory;
import com.nespot2.springsample.item.domain.ItemDetail;
import com.nespot2.springsample.item.domain.ItemStatus;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest(classes = SpringSampleApplication.class)
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemDetailRepository itemDetailRepository;

    @Test
    public void test(){

        final List<Item> itemList = itemRepository.findAll();

        for (Item item : itemList) {
            for(int i=0; i<100; i++){
                final String inventory = RandomStringUtils.randomAlphanumeric(20);
                final ItemDetail itemDetail = ItemDetail
                        .builder()
                        .inventoryNumber(inventory)
                        .createdAt(OffsetDateTime.now())
                        .modifiedAt(OffsetDateTime.now())
                        .status(ItemStatus.PURCHASE_POSSIBLE)
                        .item(item)
                        .build();
                itemDetailRepository.save(itemDetail);
            }

        }


    }

}