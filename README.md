# A9-SWTesting-FinalProject

## Deskripsi Proyek

Proyek ini merupakan tugas akhir untuk mata kuliah Software Testing. Tujuan utama proyek ini adalah mengembangkan dan menguji aplikasi menggunakan teknik dan alat pengujian yang dipelajari selama kursus, mencakup pengujian API dan aplikasi web.

### Fitur Utama

1. **Pengujian API User Controller:**
    - Verifikasi fungsionalitas berbagai endpoint API.
    - Menggunakan JUnit/TestNG untuk tes unit.
    - Menguji skenario sukses dan kegagalan.

2. **Pengujian Aplikasi Swag Labs:**
    - Menulis tes berbasis BDD dengan Cucumber.
    - Dokumentasi alur penggunaan dengan Gherkin.
    - Otomatisasi pengujian UI dengan Selenium WebDriver.

### Teknologi yang Digunakan

- **Java JDK 17**
- **Maven**
- **JUnit/TestNG**
- **Cucumber**
- **Selenium WebDriver**

Proyek ini memberikan pengalaman praktis dalam pengujian perangkat lunak dan membekali mahasiswa dengan keterampilan untuk karir di bidang ini.

### Persyaratan

Sebelum menjalankan atau berkontribusi pada proyek ini, pastikan sistem Anda memenuhi persyaratan berikut:

- Java JDK 17
- Maven
- Editor kode seperti IntelliJ IDEA atau Visual Studio Code (opsional)

## Instalasi dan Penggunaan

### Unduh atau Salin Proyek

Unduh atau salin repositori ini ke dalam sistem Anda:

```bash
git clone https://github.com/deo23/A9-SWTesting-FinalProject.git
```
### Buka Proyek

Buka proyek menggunakan editor kode pilihan Anda.

### Jalankan Uji API User Controller

- Buka terminal dengan menekan Ctrl + Shift + ~.
- Perintah untuk menjalankan test case spesifik
  
```bash
mvn test -Dtest=[Test Class name]#[Test case name]
```
### Jalankan Uji Aplikasi Swag Labs

- Buka terminal dengan menekan Ctrl + Shift + ~.
- Perintah untuk menjalankan test case spesifik:

```bash
mvn test -Dcucumber.filter.name="[scenario]"
```
## Struktur Proyek
```bash
├───.vscode
├───chromedriver-win64
├───src
│   ├───main
│   │   └───java
│   │       └───com
│   │           └───swaglabs
│   └───test
│       ├───java
│       │   ├───dummyapi
│       │   │   ├───runner
│       │   │   └───steps
│       │   └───swaglabs
│       │       ├───pages
│       │       ├───runner
│       │       ├───steps
│       │       └───utils
│       └───resources
│           └───features
│               ├───dummyapi
│               └───swaglabs
└───target
    ├───classes
    │   └───com
    │       └───swaglabs
    ├───cucumber-html-reports
    │   ├───css
    │   ├───embeddings
    │   ├───fonts
    │   ├───images
    │   └───js
    ├───cucumber-reports
    ├───generated-sources
    │   └───annotations
    ├───generated-test-sources
    │   └───test-annotations
    ├───maven-archiver
    ├───maven-status
    │   └───maven-compiler-plugin
    │       ├───compile
    │       │   └───default-compile
    │       └───testCompile
    │           └───default-testCompile
    ├───surefire-reports
    └───test-classes
        ├───dummyapi
        │   ├───runner
        │   └───steps
        ├───features
        │   ├───dummyapi
        │   └───swaglabs
        └───swaglabs
            ├───pages
            ├───runner
            ├───steps
            └───utils
```

## Penulis

Ditulis oleh Kelompok A9:

- Dafa Nurul Fauziansyah
- Fariz Rahman Maulana
- Muhammad Deo Audha Rizki

