package app;

import controller.RentarController;
import model.Mobil;
import model.Motor;
import model.PenyewaanRepository;
import model.PenyewaanRepositoryArrayList;
import view.RentalView;
import view.RentalViewCli;
import view.StrukView;
import view.StrukViewCli;
import model.Kendaraan;
import model.KendaraanFactory;
import model.KendaraanFactoryDefault;
import model.KendaraanRepository;
import model.KendaraanRepositoryArrayList;
import model.Minibus;
import model.MobilPremium;

//[DPI] main adalah composition root satu satunya tempat yang mengenal kelas konkret 
//      disinilah semua object dirakit lalu disuntiknan/deoendencies ke controller
//      
public class Main {
    public static void main(String[] args) {

        KendaraanRepository kendaraanRepository = new KendaraanRepositoryArrayList();
        PenyewaanRepository penyewaanRepository = new PenyewaanRepositoryArrayList();
        KendaraanFactory kendaraanFactory = new KendaraanFactoryDefault();
        RentalView view = new RentalViewCli();
        StrukView strukView = new StrukViewCli();

        RentarController controller = new RentarController(
                kendaraanRepository,
                penyewaanRepository,
                view,
                strukView,
                kendaraanFactory
        );

                //Data awal/dummy data
                controller.tambahDataAwal(new Mobil(
                        "S 1234 TV", 
                        "Suzuki Ertiga", 
                        350000)
                );
                controller.tambahDataAwal(new Mobil(
                        "S 2468 TY", 
                        "Honda Jazz", 
                        300000)
                );
                controller.tambahDataAwal(new Mobil(
                        "S 5678 TV", 
                        "Honda Vario", 
                        75000)
                );
                controller.tambahDataAwal(new Minibus(
                        "S 4321 TY", 
                        "Toyota Hiace", 
                        900000)
                );
                controller.tambahDataAwal(new MobilPremium(
                        "S 9 TV", 
                        "Porsche 911 Carrera",
                        1500000)
                );

                controller.jalankan();
        }
}