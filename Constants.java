package com.customer.zokudo.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Constants {

    public static final DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
    public static final String urlEscapeConstant = "\\{\\}";
    public static final String BUCKET_NAME = "autobots2.0";
    public static final String BULK_REGISTER_DIR = "bulkregisterfile";
    public static final String SECRET_KEY = "HY1GmIgvO9fTA5zwBMs36O/nvHceLPdBUYBVtwoh";
    public static final Pattern PASSPATTERN = Pattern
            .compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

    public static final String AZURE_STORAGE_CONNECTION_STRING = "DefaultEndpointsProtocol=https;" +
            "AccountName=blobmsewa;" +
            "AccountKey=ngYBCnZF6d/Bp+zRdb0JTcyCo8ZmhSjcU4OSCxhcxeLKYc90pX5H1Mw8mPcMyb2Tgw/yEEvBJ/BNDix6nzXqgQ==;";

    public static final String ACCESS_KEY = "AKIAQ7MTW3TEOGMUG4U4";

    public static final String ZOKUDO_USER = "zokudo";

    public static final String ZOKUDO_PASSWORD = "Z0kud@14";

    public static final String SET_FROM = "support@zokudo.com";

    public static final String gpr_type = "MEALMW";
    public static final String gc_type = "KUBYBR";
    public static final String BRAND_LOGO = "mbrandlogo";
    public static final String poi_poa_doc =  "mbrandlogo";//"poi_poa_doc";
    public static final String doc_type_back = "AADHAAR_BACK";
    public static final String poa_doc_type = "AADHAAR";
    public static final String poa_doc_type_voterId = "VOTER_ID";
    public static final String poa_doc_type_voterId_back = "VOTER_ID_BACK";
    public static final String poa_doc_type_dl = "DL";
    public static final String poi_doc_type = "PAN";
    public static final String OFFER_BRAND_LOGO = "mofferlogo";
    public static final String CATEGORY_LOGO_1 = "mcategorylogoone";
    public static final String CATEGORY_LOGO_2 = "mcategorylogotwo";
    public static final String CATEGORY_LOGO_3 = "mcategorylogothree";
    public static final String poa_kyc_type = "POA";
    public static final String poi_kyc_type = "POI";
    public static final String workflow_id = "COBRANDINGCIP";
    public static final String workflow_poa_id = "COBRANDINGPOACIP";
    public static String defaultProgram = "mss";
}
