/*
 * 
 * CopyRight cosmos
 */
package com.mycompany.mavenproject2;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author saif
 */
public class uploadfiletos3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Yess ");
        final String username = "dejavusaif@gmail.com";
        final String password = "Saif@9167";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("saiffarooqui9505@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("saiffarooqui9505@gmail.com, to_username_b@yahoo.com")
            );
            message.setSubject("Testing Gmail TLS");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
//        BasicAWSCredentials bs = new BasicAWSCredentials("AKIAZKNN4X5ZEQEH5QSV", "fHoX19D/oj1Yg3g5oCqnjqEw6vB3XLoyMZdu4HMV");
//        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion("us-west-2").withCredentials(new AWSStaticCredentialsProvider(bs))
//                .build();
//        String bucketName = "matrixpharamacy9167";
//        String folderName = "folder1";
//        String fileNameInS3 = "file1.txt";
//        String fileNameInLocalPC = "file1.txt";
//        PutObjectRequest putrequest = new PutObjectRequest(bucketName, folderName + "/" + fileNameInS3, new File("web/Awsproperties"));
//        s3Client.putObject(putrequest);
//        System.out.println("--Uploading file done");
//        S3Object fullObject;
//        fullObject = s3Client.getObject(new GetObjectRequest(bucketName, folderName + "/" + fileNameInS3));
//        System.out.println("--Downloading file done");
//        // Print file content line by line
//        InputStream is = fullObject.getObjectContent();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        String line;
//        System.out.println("--File content:");
//        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
//        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
