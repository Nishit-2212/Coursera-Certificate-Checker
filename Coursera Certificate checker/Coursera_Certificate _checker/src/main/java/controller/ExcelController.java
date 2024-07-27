package controller;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import dao.AdminDao;
import dao.LoginDao;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Student;



/**
 * Servlet implementation class ExcelController
 */
@WebServlet("/ExcelController")
@MultipartConfig
public class ExcelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		InputStream fileContent = null;
        try {
            Part filePart = request.getPart("file");
            fileContent = filePart.getInputStream();
            Workbook workbook = WorkbookFactory.create(fileContent);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            List<Student> students = new ArrayList<>();
            int rowIndex = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (rowIndex == 0) {
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.cellIterator();
                Student student = new Student();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int columnIndex = cell.getColumnIndex();
                    switch (columnIndex) {
                        case 0:
                            student.setName(getStringValue(cell));
                            break;
                        case 1:
                            student.setDept_id(getNumericValue(cell));
                            break;
                        case 2:
                            student.setSem_id(getNumericValue(cell));
                            break;
                        case 3:
                            student.setDiv_id(getNumericValue(cell));
                            break;
                        case 4:
                            student.setEmail(getStringValue(cell));
                            break;
                        case 5:
                            student.setPassword(getStringValue(cell));
                            break;
                        case 6:
                            student.setEnrollment_no(getStringValue(cell));
                            break;
                        default:
                            break;
                    }
                }
                students.add(student);
                AdminDao.addstudent(student);
                System.out.println(students);
            }
            System.out.println("----------------------------------------------");
            System.out.println(students);
            request.setAttribute("students", students);
            request.getRequestDispatcher("studentcrud.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileContent != null) {
                fileContent.close();
            }
        }
    }

    private String getStringValue(Cell cell) {
        switch (cell.getCellTypeEnum()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                // If the cell is numeric, convert it to string
                return String.valueOf((int) cell.getNumericCellValue());
            default:
                return ""; // Handle other cell types as needed
        }
    }

    private int getNumericValue(Cell cell) {
        switch (cell.getCellTypeEnum()) {
            case NUMERIC:
                return (int) cell.getNumericCellValue();
            default:
                return 0; // Handle other cell types or empty cells as needed
        }
    }
}