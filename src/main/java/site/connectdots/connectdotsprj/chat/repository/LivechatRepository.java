package site.connectdots.connectdotsprj.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import site.connectdots.connectdotsprj.chat.entity.Livechat;

import java.util.List;

public interface LivechatRepository extends JpaRepository<Livechat, Long> {
    @Query("SELECT lc.livechatHashtag " +
            "FROM Livechat lc " +
            "GROUP BY lc.livechatHashtag " +
            "ORDER BY COUNT(lc) DESC")
    List<String> findHashtagsOrderByCount();

    List<Livechat> findAllByLivechatHashtag(String hashtag);

}
