package week_4.day_4;

import java.util.List;

public interface MemberDAO {
  // Create member
  public Member createMember(Member newMember);

  // Get all members
  public List<Member> findAllMembers();

  // Get specific member
  public Member findMemberByEmail(String email);

  // Update member
  public boolean updateMember(Member updatedMember);

  // Delete member
  public boolean deleteMemberById(String email);
}