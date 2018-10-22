package BLL;

public class Constants {

    private final String adminCss = "<head>\n" +
            "<style>\n" +
            "#customers {\n" +
            "    font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
            "    border-collapse: collapse;\n" +
            "    width: 100%;\n" +
            "}\n" +
            "\n" +
            "#customers td, #customers th {\n" +
            "    border: 1px solid #ddd;\n" +
            "    padding: 8px;\n" +
            "}\n" +
            "\n" +
            "#customers tr:nth-child(even){background-color: #f2f2f2;}\n" +
            "\n" +
            "#customers tr:hover {background-color: #ddd;}\n" +
            "\n" +
            "#customers th {\n" +
            "    padding-top: 12px;\n" +
            "    padding-bottom: 12px;\n" +
            "    text-align: left;\n" +
            "    background-color: #4CAF50;\n" +
            "    color: white;\n" +
            "}\n" +
            "</style>\n" +
            "<style>\n" +
            "input[type=text], select {\n" +
            "    width: 50%;\n" +
            "    padding: 12px 20px;\n" +
            "    margin: 8px 0;\n" +
            "    display: inline-block;\n" +
            "    border: 1px solid #ccc;\n" +
            "    border-radius: 4px;\n" +
            "    box-sizing: border-box;\n" +
            "}\n" +
            "\n" +
            "input[type=submit] {\n" +
            "    width: 15%;\n" +
            "    background-color: #4CAF50;\n" +
            "    color: white;\n" +
            "    padding: 14px 20px;\n" +
            "    margin: 8px 0;\n" +
            "    border: none;\n" +
            "    border-radius: 4px;\n" +
            "    cursor: pointer;\n" +
            "}" +
            "\n" +
            "input[type=submit]:hover {\n" +
            "    background-color: #45a049;\n" +
            "}\n" +
            "\n" +
            "div {\n" +
            "    border-radius: 5px;\n" +
            "    background-color: #f2f2f2;\n" +
            "    padding: 20px;\n" +
            "}\n" +
            "</style>" +
            "</head>";

    private final String adminLogOutButton = "  <form action=\"LogOutServlet\" method=\"GET\">\n" +
            "    <input type=\"submit\" value=\"Log Out\">\n" +
            "  </form>\n";

    public String getAdminCss() {
        return adminCss;
    }

    public String getAdminLogOutButton() {
        return adminLogOutButton;
    }
}
