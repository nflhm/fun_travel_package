package id.co.travel.fun.controller;

import id.co.travel.fun.model.Package;
import id.co.travel.fun.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("package")
public class PackageController {
    @Autowired
    PackageService packageService;

    @GetMapping("/")
    public @ResponseBody List<Package> selectAllPackage(@RequestParam("page") int page,
                                                        @RequestParam("size") int size) {
        return packageService.allPackagesPage(page, size);
    }
    @GetMapping("/id")
    public @ResponseBody Package selectUnique(@RequestParam("id") int id) {
        Package model = new Package();
        model.setId(id);
        return packageService.findThePackage(model);
    }
    @GetMapping("/add")
    public String addPackage(@RequestParam("name") String packageName,
                             @RequestParam("price") int packagePrice,
                             @RequestParam("desc") String packageDesc) {
        Package model = new Package(0, packageName, packagePrice, packageDesc);
        packageService.insert(model);
        return "redirect:/package/?page=0&size=10";
    }
    @GetMapping("/update")
    public String updateEmployee(@RequestParam("id") int id,
                                 @RequestParam("name") String packageName,
                                 @RequestParam("price") int packagePrice,
                                 @RequestParam("desc") String packageDesc) {
        Package model = new Package(id, packageName, packagePrice,packageDesc);
        packageService.update(model);
        return "redirect:/package/?page=0&size=10";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") int id) {
        Package model = new Package();
        model.setId(id);
        packageService.delete(model);
        return "redirect:/package/?page=0&size=10";
    }
}
