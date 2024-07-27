package controller;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.eclipse.jdt.internal.compiler.tool.EclipseCompiler;

import dao.AdminDao;
import dao.UploadDao;
import model.Student;

@WebServlet("/UploadController")
@MultipartConfig
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("upload")) {

			String selectedOption = request.getParameter("dropdown");
			
			
			HttpSession session = request.getSession();
		    // Now you can use the session object as needed
		    // For example, to retrieve attributes from the session:
		    Student student = (Student) session.getAttribute("s");
		    
		    int studentid = student.getId();
		    String enrollment = student.getEnrollment_no();
		    int semester = student.getSem_id();
		    int department = student.getDept_id();
		    int division = student.getDiv_id();
		    System.out.println("EnrollmentNO is:"+enrollment);
			
			System.out.println("Student_id:-" + studentid);
			int course_id = UploadDao.get_Courseid(selectedOption);
			String department_name = UploadDao.get_Departmentname(department);
			String semester_name = UploadDao.get_Semestername(semester);
			String division_name = UploadDao.get_divisionname(division);

			System.out.println("Course Id is:-"+course_id);
			System.out.println(selectedOption);
			System.out.println("Selected Option: " +semester);
			System.out.println("department id:-" +department);
			System.out.println("department name:-" +department_name);
			System.out.println("semester_name:-" +semester_name);
			System.out.println("division:-" +division);
			System.out.println("division name:-" +division_name);
			System.out.println("Selected Option: " + selectedOption);
			
			
			
			// save path
//			String savePath = "C:\\Users\\Nishit\\eclipse-workspace\\Coursera_Certificate _checker\\certficates";
		    String newpath = "C:\\Users\\Nishit\\eclipse-workspace\\Coursera_Certificate _checker\\certficates";  
		    String savePath = newpath + "\\" + department_name + "\\" + semester_name + "\\" + division_name ;
		    		
		    		
		    File fileSaveDir = new File(savePath);
		      if (!fileSaveDir.exists()) {
		          fileSaveDir.mkdir();
		      }

		     
		      
		      
		    
		     
		     
		      String directory = "certificates\\";
		     
		      
		      

		     
			
			
			

			// extract name
			try {
				Part filePart = request.getPart("pdfFile");
				InputStream pdfInputStream = filePart.getInputStream();

				PDDocument document = PDDocument.load(pdfInputStream);
				PDFTextStripper pdfTextStripper = new PDFTextStripper();
				String text = pdfTextStripper.getText(document);

				String[] lines = text.split(System.lineSeparator());
				System.out.println("Total number of lines in the PDF: " + lines.length);

				System.out.println(selectedOption);

				String line1 = lines[1];
				String line3 = lines[2];
				String line4 = lines[3];
				String line5 = lines[4];
				String line6 = lines[5];
				String per = "an online non-credit";

				String name = null;
				int i;

				String[] sentences = line3.split("\\s+");
				String[] sentences1 = line4.split("\\s+");

				String firstSentence = sentences[0];
				String secondSentence = sentences1[0];

				String line2 = line1.replaceAll("\\s+", " ");
				System.out.println("Line 2:" + line2);
				System.out.println("First sentence: " + firstSentence);
				System.out.println("Second sentence: " + secondSentence);
				
				
				//for file saving 
				String fileName = "21003501210020_java.pdf";
		        String fullPath = savePath + File.separator + fileName;
		        int jj =0;
		        
		        for (Part part : request.getParts()) {
		        	if(jj == 0) {
			          fileName = extractFileName(part);
			          System.out.println("file namesss:-"+fileName);
		        	  jj++;
		        	}
			      }
		       
		        String savePaths = newpath + "\\" + department_name + "\\" + semester_name + "\\" + division_name + "\\" + fileName;

				if (selectedOption.contains(firstSentence)) {
					System.out.println("match");
				} else if (selectedOption.contains(secondSentence)) {
					System.out.println("match1");
				}

				if (selectedOption.contains(firstSentence)) {
					name = line2;
					System.out.println(name);
					Boolean flag = UploadDao.checknamedsd(name,department , semester, division);
					Boolean flag1 = UploadDao.checkc(studentid, course_id);
					if (flag == true) {
						if(flag1 == false) {
						
							UploadDao.insertstatus(studentid, course_id, savePaths);
						request.setAttribute("msg", "submitted succesfully");
						
						
						request.setAttribute("extractedName", name);
						for (Part part : request.getParts()) {
					          fileName = extractFileName(part);
					          System.out.println("file name:-"+fileName);
					          fullPath = savePath + File.separator + fileName;
					          part.write(savePath + File.separator + fileName);
					      }
						
						}
						else {
							request.setAttribute("msg", "already submitted certificate ");
						}
					} else {
						request.setAttribute("msg", "Fail to submit ");

					}
				} else if (selectedOption.contains(secondSentence)) {
					name = line2 + " " + line3;
					Boolean flag = UploadDao.checknamedsd(name,department , semester, division);
					Boolean flag1 = UploadDao.checkc(studentid, course_id);
					if (flag == true) {
						if (flag1 == false) {
						UploadDao.insertstatus(studentid, course_id, savePath);
						request.setAttribute("msg", "submitted succesfully");
						System.out.println("submitted succesfully");
						
						request.setAttribute("extractedName", name);
						for (Part part : request.getParts()) {
					          fileName = extractFileName(part);
					          fullPath = savePath + File.separator + fileName;
					          part.write(savePath + File.separator + fileName);
					      }}
						else {
							request.setAttribute("msg", "already submitted certificate ");
							System.out.println("already submitted certificate ");
						}
					} else {

						request.setAttribute("msg", "Fail to submit f ");
						System.out.println("Fail to submit f ");

					}
				} else {

					request.setAttribute("msg", "Fail to submit ");
				}

				System.out.println(selectedOption);
				System.out.println(line3);

				System.out.println(name);

				request.setAttribute("extractedName", name);

				document.close();

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("extractionError", "Error extracting lines from PDF.");

			}
			
			
			
			
			
			

			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		if(action.equalsIgnoreCase("Submit Query")) {
			String query= request.getParameter("name");
			int id =  Integer.parseInt(request.getParameter("id")) ;
			
			AdminDao.submitquery(query, id);
			request.setAttribute("msg", "successfully submited qeury");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
		

	}
	
	
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}