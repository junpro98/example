<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>
<% /* 파일이 저장되는 코드 */
/* 파일이 저장되는 코드 */
/* 파일이 저장되는 코드 */
/* 파일이 저장되는 코드 */
/* 파일이 저장되는 코드 */
/* 파일이 저장되는 코드 */
/* 파일이 저장되는 코드 */
/* 파일이 저장되는 코드 */
/* 파일이 저장되는 코드 */
	String uploadPath=request.getRealPath("/file");
	/* WebContent에 들어가있기 때문에 폴더도 WebContent에 만들면 된다. */
	int size = 10*1024*1024;
	/* 업로드하는 파일의 사이즈 위 사이즈는 10mb정도 된다. */
	String name="";
	String subject="";
	String filename1="";
	String origfilename1="";
	
	try{
		MultipartRequest multi=new MultipartRequest(request,
				/* 전에 페이지에서 우리가 parameter값을 받아왔는데 파일은 MultipartRequest만 된다. */
							uploadPath,
							size, 
							"UTF-8",
				new DefaultFileRenamePolicy());

		name=multi.getParameter("name");
		subject=multi.getParameter("subject");
		
		Enumeration files=multi.getFileNames();
		/* getFileNames로 한 이유는 첨부파일 박스가 1개가 아니라 여러개면 복수 형태가 될 수 있기 떄문에. */
		
		/* 첨부파일 박스가 한개 더 추가하면 아래 있는 3줄의 코드가 하나씩 늘어나면 된다.*/
		String file1 =(String)files.nextElement();
		filename1=multi.getFilesystemName(file1);
		origfilename1= multi.getOriginalFileName(file1);
		/* 이건 만약 같은 이름의 파일 이름이면 우리가 저장 될때 1(1) 이렇게 되는데, 그거랑 같은거임. */
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<html>
<body>
<form name="filecheck" action="fileCheck.jsp" method="post">
	<input type="hidden" name="name" value="<%=name%>">
	<input type="hidden" name="subject" value="<%=subject%>">
	<input type="hidden" name="filename1" value="<%=filename1%>">
	<input type="hidden" name="origfilename1" value="<%=origfilename1%>">
</form>
<a href="#" onclick="javascript:filecheck.submit()">업로드 확인 및 다운로드 페이지 이동</a>
</body>
</html>
