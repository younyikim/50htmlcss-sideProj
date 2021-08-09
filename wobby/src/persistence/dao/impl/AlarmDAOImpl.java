package persistence.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.AlarmDAO;
import service.dto.AlarmDTO;
import service.dto.MsgDTO;

public class AlarmDAOImpl implements AlarmDAO {
	
	private JDBCUtil jdbcUtil = null;

	public AlarmDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}

	/**
	 * AlarmList ��ȯ
	 */
	public List<AlarmDTO> getAlarmList(String userId) {
		String query = "SELECT ALARMLISTNO, POST_ID, COMMENT_ID " + 
						"FROM ALRAMLIST " + 
						"WHERE USER_ID = ?";
		jdbcUtil.setSqlAndParameters(query, new Object[] { userId }); // JDBCUtil �� query ����

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query �� ����
			List<AlarmDTO> list = new ArrayList<AlarmDTO>(); // MsgDTO ��ü���� ������� list ��ü
			while (rs.next()) {
				AlarmDTO dto = new AlarmDTO(); // �ϳ��� MsgDTO ��ü ���� �� ���� ����
				dto.setAlarmNo(rs.getString("ALARMLISTNO"));
				dto.setAlarmNo(rs.getString("POST_ID"));
				dto.setAlarmNo(rs.getString("COMMENT_ID"));
				list.add(dto);
			}
			return list;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // ResultSet, PreparedStatement, Connection ��ȯ
		}
		return null;
	}

	public int deleteAlarm(String alarmNo) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM ALARMLIST WHERE ALARMLISTNO = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { alarmNo }); // JDBCUtil�� delete���� �Ű� ���� ����

		try {
			int result = jdbcUtil.executeUpdate(); // delete �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource ��ȯ
		}
		return 0;
	}
}

/*
2.hobbyDAO�� �ʿ����. ����ڰ� ���� �߰��ϴ� �� �ƴ϶� �ִ� hobby���� ��󾲴� �����̶� �ʿ� X, ����ڰ� ���� �ÿ� ������ ��� �߿� ��̸� ���߼����ؼ� �����ϴµ� �̶� DB�� �����Ϸ��� 
�޼ҵ带 ���� �������ϴ��� or createUser�޼ҵ忡�� �迭�� ���� hobbyList�� �߰��� �� �ִ���?
   */