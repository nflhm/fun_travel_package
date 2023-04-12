package id.co.travel.fun.service;

import id.co.travel.fun.model.Package;
import id.co.travel.fun.repository.IPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {
    @Autowired
    IPackageRepository packageRepository;

    public void insert(Package holidayPkg) { packageRepository.save(holidayPkg); }

    public void update(Package holidayPkg) {
        packageRepository.save(holidayPkg);
    }

    public void delete(Package holidayPkg) {
        packageRepository.deleteById(holidayPkg.getId());
    }

    public Package findThePackage(Package holidayPkg) {
        return packageRepository.findPackageById(holidayPkg.getId());
    }

    public List<Package> allPackages() {
        return packageRepository.findAllByOrderByPackageName();
    }

    public List<Package> allPackagesPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return packageRepository.findAll(pageable).getContent();
    }
}
