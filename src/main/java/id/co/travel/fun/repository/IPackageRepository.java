package id.co.travel.fun.repository;

import id.co.travel.fun.model.Package;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPackageRepository extends JpaRepository<Package, Integer>  {
    Package findPackageById(Integer integer);
    List<Package> findAllByOrderByPackageName();
    Page<Package> findAllByOrderByPackageName(Pageable pageable);
}
