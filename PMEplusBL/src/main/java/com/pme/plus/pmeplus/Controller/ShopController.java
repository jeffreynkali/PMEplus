package com.pme.plus.pmeplus.Controller;

import com.pme.plus.pmeplus.Entity.Shop;
import com.pme.plus.pmeplus.api.Service.ShopServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by gnkali on 8/6/17.
 */
@Controller("shopController")
public class ShopController {

    private ShopServiceAPI shopService;

    @Autowired
    public void setShopService(ShopServiceAPI shopService) {
        this.shopService = shopService;
    }

    @RequestMapping("shop/new")
    public String newShop(Model model){
        model.addAttribute("shop", new Shop());
        return "shopform";
    }

    @RequestMapping(value = "shop", method = RequestMethod.POST)
    public String saveShop(Shop shop){
        shopService.saveShop(shop);
        return "redirect:/shop/" + shop.getIdShop();
    }

    @RequestMapping("shop/{id}")
    public String showShop(@PathVariable Integer id, Model model){
        model.addAttribute("shop", shopService.getShopById(id));
        return "shopshow";
    }

    @RequestMapping(value = "/shops", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("shops", shopService.listAllShops());
        return "shops";
    }

    @RequestMapping("shop/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("shop", shopService.getShopById(id));
        return "shopform";
    }

    @RequestMapping("shop/delete/{id}")
    public String delete(@PathVariable Integer id){
        shopService.deleteShop(id);
        return "redirect:/shops";
    }
}

