package com.munihuamanga.lf_backend.services.impl;


import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.munihuamanga.lf_backend.models.dto.CertificadoDTO;
import com.munihuamanga.lf_backend.models.dto.NombreDTO;
import com.munihuamanga.lf_backend.models.entities.Licencia;
import com.munihuamanga.lf_backend.models.mapper.CertificadoMapper;
import com.munihuamanga.lf_backend.repository.CertificadoRepository;
import com.munihuamanga.lf_backend.repository.LicenciaRepository;
import com.munihuamanga.lf_backend.services.CertificadoService;
import net.glxn.qrgen.QRCode;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@Service
public class CertificadoServiceImpl implements CertificadoService {

    private final CertificadoRepository certificadoRepository;
    private final CertificadoMapper certificadoMapper;
    private final LicenciaRepository licenciaRepository;

    CertificadoServiceImpl(CertificadoRepository certificadoRepository,
                           CertificadoMapper certificadoMapper,
                           LicenciaRepository licenciaRepository){
        this.certificadoRepository = certificadoRepository;
        this.certificadoMapper = certificadoMapper;
        this.licenciaRepository = licenciaRepository;
    }

    @Override
    public CertificadoDTO getCertificado(Long id) {
        return null;
    }

    @Override
    public void createCertificado(CertificadoDTO certificadoDTO) {
        Licencia licencia = licenciaRepository.findById(certificadoDTO.getLicenciaId())
                .orElseThrow(() -> new RuntimeException("Licencia no encontrada"));
        NombreDTO nombreDTO = licenciaRepository.findDetallesByLicenciaId(certificadoDTO.getLicenciaId());
        String rutaPlantilla = Paths.get("").toAbsolutePath().toString()+ File.separator+"archivos"+File.
                separator+"plantilla"+File.separator+"plantilla.pdf";
        String rutaDestino  = Paths.get("").toAbsolutePath().toString()+ File.separator+"archivos"+File.
                separator+"plantilla" +File.separator + licencia.getNumero() + ".pdf";


        String datosQR = "Numero Lic:"+licencia.getNumero()+
               ", Fecha Emision:"+licencia.getFechaEmision()+
               ",Fecha Vencimiento:"+licencia.getFechaVencimiento();
        String urlQR = generarCodigoQR(datosQR, licencia);

        generarCertificado(rutaPlantilla, rutaDestino,licencia, nombreDTO, urlQR);
    }

   private String generarCodigoQR(String datos, Licencia licencia) {
       String directorioQR =Paths.get("").toAbsolutePath().toString()+ File.separator+"archivos"+File.separator+"qr";
       String nombreArchivoQR = "QR_" + licencia.getNumero() + ".png";
       String rutaCompletaQR = directorioQR + nombreArchivoQR;

       ByteArrayOutputStream qrOutputStream = QRCode.from(datos).withSize(100, 100).stream();
       try {
           Path rutaQR = Paths.get(rutaCompletaQR);
           Files.write(rutaQR, qrOutputStream.toByteArray());
       } catch (IOException e) {
           e.printStackTrace();
           return null;
       }
       return rutaCompletaQR;
    }

    public void generarCertificado(String rutaPlantilla, String rutaDestino,Licencia licencia, NombreDTO nombreDTO, String rutaCodigoQR) {
        try {

            PdfDocument pdfDoc = new PdfDocument(new PdfReader(rutaPlantilla), new PdfWriter(rutaDestino));
            Document document = new Document(pdfDoc);

            // Agregar los datos de la licencia
            // Nota: este es un ejemplo básico, ajusta según tus necesidades y estructura de DatosLicencia
            document.add(new Paragraph("Número de Licencia: " + licencia.getNumero())
                    .setFixedPosition(1, 200, 400, 500));
            document.add(new Paragraph("Fecha de Emisión: " + licencia.getFechaEmision()))
                            .setFixedPosition(1, 400, 100, 400);
            document.add(new Paragraph("Fecha de Expiración: " + licencia.getFechaVencimiento()));
            document.add(new Paragraph("Razon Social: " + nombreDTO.getRazonSocial()));
            document.add(new Paragraph("Dirección: " + nombreDTO.getDireccion())).
                    setFixedPosition(1, 450, 320, 400);
            document.add(new Paragraph("RUC: " + nombreDTO.getRuc()));
            document.add(new Paragraph("Giro de Negocio: " + nombreDTO.getNombreGiroNegocio()));
            // Agrega más campos según sea necesario

            // Agregar el código QR
            ImageData imageData = ImageDataFactory.create(rutaCodigoQR);
            Image qrCode = new Image(imageData);
            qrCode.setFixedPosition(1, 620, 380, 100);
            qrCode.scaleToFit(100, 100); // Ajusta el tamaño del código QR (opcional
            document.add(qrCode);

            document.close(); // Cierra el documento y aplica los cambios
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public CertificadoDTO updateCertificado(Long id, CertificadoDTO certificadoDTO) {
        return null;
    }

    @Override
    public void deleteCertificado(Long id) {

    }

    @Override
    public List<CertificadoDTO> getCertificados() {
        return null;
    }
}
