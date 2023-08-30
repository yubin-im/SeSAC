package test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * <pre>
 * Socket ���� ���α׷� ����
 * @author �����
 * 1. ServerSocket ����
 * 1-1. ServerSocket server = new S(5555);
 * 2. bind() : 50, 1���ܰ迡�� ���������� ����
 * 3. accept() : Socket(���� ����) 
 *     <- Ŭ���̾�Ʈ�� new Socket()�� ���� �������, ���� ������ �ش� Ŭ���̾�Ʈ ���Ͽ� ����, ���ѵǾ� �����Ѵ�.
 * 3-1. Socket service = server.accept();
 * 4. 3���� ��ü���� InputStream/OutputStream�� ����.
 * 4-1. In in = service.getI; Out out = service.getOut
 * 5. input-> read(), output-> write()
 * 5-1. in.read();  out.write();
 * 6. close() < ���� ����
 * 6-1. service.close();
 * 7. close() <- ServerSocket - �Ϲ������δ� 7���� �������� �ʾƵ� �ȴ�.
 * 7-1. server.close();
 * </pre>
 */
public class TestSocket {
	ArrayList<Socket> serviceList = new ArrayList<Socket>();
	static ArrayList<PrintWriter> outList = new ArrayList();
	static ServerSocket server;
	public static void main(String[] args) throws IOException {
		 server = new ServerSocket(5555);
		 System.out.println("Server:5555 is running");
		 while(true)
		 {
			 Socket service = server.accept();
			 System.out.println("[" + service.getRemoteSocketAddress() + "] is accepted.");
			 new Thread(new Service(service, outList)).start();
		 }
	}

}


class Service implements Runnable {

	private Socket service;
	private ArrayList<PrintWriter> outList;
	private BufferedReader in;
	private PrintWriter out;

	public Service(Socket service, ArrayList<PrintWriter> outList) {
		this.service = service;
		this.outList = outList;
		try {
			in = new BufferedReader(new InputStreamReader(service.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(service.getOutputStream()));
			outList.add(out);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void run() {
		String client = "[" + service.getRemoteSocketAddress() + "]";
		String data = "";
		System.out.println(Thread.currentThread() + " is received.");
		 while(true)
		 {
			 try {
				data = in.readLine();
				System.out.println(data + " is received.");
			} catch (IOException e) {
				e.printStackTrace();
			}
			 System.out.println("received data>" + client + " :: " + data);			 
			 sendToClient(client + " :: " + data);
			 if(data.equals("exit"))	close();
			 else if(data.equals("shutdown")) exit();
		 }
	}

	private void sendToClient(String data) {
		for (PrintWriter out : outList) {
			out.println(data);
			out.flush();
		}
	}

	private void exit() {
		// TODO Auto-generated method stub
		close();
		try {
			TestSocket.server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

	private void close() {
		 try {
			 for (PrintWriter out : outList) {
				 out.close(); 
			}
			 outList.removeAll(outList); in.close(); service.close();
		} catch (IOException e) {			e.printStackTrace();		}

	}

}






