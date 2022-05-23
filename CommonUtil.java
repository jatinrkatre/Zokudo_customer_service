package com.customer.zokudo.util;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.customer.zokudo.dto.request.PageDTO;
import com.customer.zokudo.enums.BizErrors;
import com.customer.zokudo.exceptions.BizException;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.*;
import lombok.extern.slf4j.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
public class CommonUtil {

    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
    public static SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat dateFormate2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public static SimpleDateFormat formatter3 = new SimpleDateFormat("ddMMyyyy");
    static final String SOURCE = "0123456789ABCDFGHIJKLMNOPQRSTUVWXYZ0123456789abcdfghijklmnopqrstuvwxyz";

    public static final String startTime = " 00:00:00";
    public static final String endTime = " 23:59:59";

    public static final AWSCredentials credentials = new BasicAWSCredentials(Constants.ACCESS_KEY, Constants.SECRET_KEY);
    public static final AmazonS3 s3Client = new AmazonS3Client(credentials);

    private static final String ADMIN_PROGRAM_URL ="mss";
    private static final String ZOKUDO_APP_USER_PROGRAM_URL= "appuser";

    static SecureRandom secureRnd = new SecureRandom();

    public static String[] getProgramAndRequestUrl(HttpServletRequest request) {
        return request.getRequestURI().split("/");
    }

    public static String getBasicAuthorization(String applicationLevelUserName, String applicationLevelUserPassword) {
        String result = "Basic ";
        String credentials = applicationLevelUserName + ":" + applicationLevelUserPassword;
        result = result + DatatypeConverter.printBase64Binary(credentials.getBytes(StandardCharsets.UTF_8));
        return result;
    }

    public static String getString(String description) {
        if (description != null) {
            return description.replaceAll("\\W", " ");
        }
        return null;
    }

    public static boolean isValidMobileNumber(String str) {
        try {
            return str.trim().matches("^(?=(?:[6-9]){1})(?=[0-9]{10}).*");
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidTitle(String str) {
        try {
            switch (str) {
                case "Mr":
                case "Ms":
                case "Mrs":
                    return true;
            }
        } catch (Exception e) {
            throw new BizException(BizErrors.NULL_ERROR.getValue(), "title should not be empty");
        }
        return false;
    }

    public static boolean isValidGender(String str) {
        try {
            switch (str) {
                case "M":
                case "F":
                    return true;
            }
        } catch (Exception e) {
            throw new BizException(BizErrors.NULL_ERROR.getValue(), "Gender should not be empty");
        }
        return false;
    }

    /**
     *
     * @param pDate
     * @return date in yyyy-MM-dd format is Valid
     * @throws ParseException
     * @author vsahoo@msewa.com
     */
    public static String getDateYYYMMDD(String pDate) throws ParseException {

        log.info("Into getDateYYYMMDD() CommonUtil for date parsing. Unparsed Date: "+pDate);
        String pattern = null;
        SimpleDateFormat simpleDateFormat2 = null;

        //Regex for dd/MM/yyyy and dd-MM-yyyy
        if(pDate.matches("^(((0[1-9]|[12][0-9]|30)[-/]?(0[13-9]|1[012])|31[-/]?(0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-/]?02)[-/]?[0-9]{4}|29[-/]?02[-/]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$")) {
            if(pDate.contains("/"))
                pattern = "dd/MM/yyyy";
            else
                pattern = "dd-MM-yyyy";
        } //Regex for MM/dd/yyyy and MM-dd-yyyy
        else if(pDate.matches("^(((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))[-/]?[0-9]{4}|02[-/]?29[-/]?([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$")){

            if(pDate.contains("/"))
                pattern = "MM/dd/yyyy";
            else
                pattern = "MM-dd-yyyy";

        }else if(pDate.matches("^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$")) {

            if(pDate.contains("/"))
                pattern = "yyyy/MM/dd";
            else
                pattern = "yyyy-MM-dd";

        }else {
            return "Invalid";
        }

        log.info("BEFORE Date parse. Unparsed Date: "+pDate," , Pattern To be Parsed : "+pattern);
        simpleDateFormat2 = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat2.parse(pDate);
        String parsedDate = formatter.format(date);
        log.info("AFTER Date parse. Parsed Date: "+parsedDate);
        return parsedDate;

    }

    // date format should be like YYYY-MM-DD
    public static boolean dobValidate(String date) {
        try {
            Constants.dateFormat.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String checkDate = "30-01-1992";
        try {
            String changedDate = getDateYYYMMDD(checkDate);
            System.out.println("changed date: "+changedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //System.out.println("is correct: "+isCorrect);

    }

    public static boolean validIdType(String idType) {
        switch (idType) {
            case "AADHAAR":
            case "PAN":
            case "driver_id":
            case "PASSPORT":
                return true;
        }
        return false;
    }


    public static boolean validCountry(String countryOfIssue) {
        return "India".equals(countryOfIssue);
    }

    public static void generateExcelSheet(final List<String> headers, final List<Map<String, String>> dataList, String resultantFileName, HttpServletResponse response) {
        try {
            if (headers == null || headers.size() == 0) {
                return;
            }
            if (dataList == null || dataList.size() == 0) {
                return;
            }
            final XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFCellStyle cellStyle = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setBold(true);
            cellStyle.setFont(font);

            final XSSFSheet sheet = workbook.createSheet();
            XSSFRow xssfRow = sheet.createRow(0);
            for (int i = 0; i < headers.size(); i++) {
                XSSFCell xssfCell = xssfRow.createCell(i);
                xssfCell.setCellStyle(cellStyle);
                xssfCell.setCellValue(headers.get(i));
            }
            for (int j = 0; j < dataList.size(); j++) {
                XSSFRow row = sheet.createRow((j + 1));
                Map<String, String> eachDataMap = dataList.get(j);
                for (int k = 0; k < headers.size(); k++) {
                    XSSFCell cell = row.createCell(k);
                    String key = headers.get(k);
                    String value = eachDataMap.get(key);
                    cell.setCellValue(value);
                }
            }
            response.setHeader("Content-Type", MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.setHeader("Content-Disposition", "attachment; filename=" + resultantFileName);

            final ServletOutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            workbook.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return;
        }
    }

    /**
     * UPLOADING FILES TO AZURE BLOB STORAGE
     * file - file to be uploaded,
     * directory - azure container name
     * id - id to be applied to make create unique reference at azure storage
     **/
    public static String uploadBulkFile(MultipartFile file, String id, String directory) throws IOException {
        try {
            CloudStorageAccount storageAccount;
            CloudBlobClient blobClient = null;
            CloudBlobContainer container=null;
            String uri = "";
            String fileExtension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String fileName =  generateFileKey(id) + fileExtension;

                // Parse the connection string and create a blob client to interact with Blob storage
                storageAccount = CloudStorageAccount.parse(Constants.AZURE_STORAGE_CONNECTION_STRING);
                blobClient = storageAccount.createCloudBlobClient();
                container = blobClient.getContainerReference(directory);

                // Create the container if it does not exist with public access.
                log.info("Creating container: " + container.getName());
                container.createIfNotExists(BlobContainerPublicAccessType.CONTAINER, new BlobRequestOptions(), new OperationContext());

                //Getting a blob reference
                CloudBlockBlob blob = container.getBlockBlobReference(fileName);

                //Creating blob and uploading file to it
                log.info("Uploading the file: "+ file.getName());
                blob.upload(file.getInputStream(), file.getSize());

                return  blob.getUri().toString();
            }
            catch (StorageException ex)
            {
                log.error(String.format("Error returned from the service. Http code: %d and error code: %s", ex.getHttpStatusCode(), ex.getErrorCode()));
                throw new BizException(BizErrors.APPLICATION_ERROR.getValue(), "file upload operation failed!");
            }
            catch (Exception e)
            {
                log.error(e.getMessage());
                throw new BizException(BizErrors.APPLICATION_ERROR.getValue(), "file upload operation failed!");
            }
    }

    public static String generateFileKey(String id) {
        try {
            String systemMillis = String.valueOf(System.currentTimeMillis());
            return id + "_" + systemMillis;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean isValidNumber(String number) {
    	for (int i = 0; i < number.length(); i++) {
			if(!Character.isDigit(number.charAt(i)))
				return false;
		}
    	return true;
    }

    public static String generateSixDigitNumericString() {
        int number = (int) (Math.random() * 1000000);
        return String.format("%06d", number);
    }
    
    public static boolean isNumeric(String str) {
        try {
            return str.trim().matches("[0-9]+");
        } catch (Exception e) {
            return false;
        }
    }

    public static Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 0, 0, 0);
        return calendar.getTime();
    }

    public static Date getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 23, 59, 59);
        return calendar.getTime();
    }

    public static boolean isValidId(final double id) {
        return id > 0;
    }
    public static Pageable getPageableInfo(final PageDTO dto) {
        return getPageable(dto.getPage(), dto.getSize(), dto.getOrder(), dto.getProperty());
    }

    private static Pageable getPageable(final int pageNo, final int pageSize, final String direction, final String property) {
        final int pageSizeLocal = pageSize != 0 ? pageSize : 20;
        final Sort.Direction directionLocal = StringUtils.isNotEmpty(direction) ? Sort.Direction.valueOf(direction) : Sort.Direction.DESC;
        final String propertyLocal = StringUtils.isNotEmpty(property) ? property : "createdAt";
        return PageRequest.of(pageNo, pageSizeLocal, directionLocal, propertyLocal);
    }
    
    public static String randomString(int length, String preVal) {
        String brandKey = null;
            brandKey = preVal.toUpperCase();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(SOURCE.charAt(secureRnd.nextInt(SOURCE.length())));
        return brandKey + sb.toString().toUpperCase();
    }

    public static boolean isAtCustomerLevel(String programUrl){
        log.info(" Program URL is : ",programUrl);
        return programUrl.equalsIgnoreCase(ADMIN_PROGRAM_URL) || programUrl.equalsIgnoreCase(ZOKUDO_APP_USER_PROGRAM_URL);
    }
}
