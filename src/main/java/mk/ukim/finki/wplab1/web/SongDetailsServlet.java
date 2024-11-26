package mk.ukim.finki.wplab1.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wplab1.model.Artist;
import mk.ukim.finki.wplab1.model.Song;
import mk.ukim.finki.wplab1.service.ArtistService;
import mk.ukim.finki.wplab1.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "SongDetailsServlet", urlPatterns = "/songDetails")
public class SongDetailsServlet extends HttpServlet {
    protected final SpringTemplateEngine springTemplateEngine;
    protected final SongService songService;
    protected final ArtistService artistService;

    public SongDetailsServlet(SpringTemplateEngine springTemplateEngine, SongService songService, ArtistService artistService) {
        this.springTemplateEngine = springTemplateEngine;
        this.songService = songService;
        this.artistService = artistService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        Song s = songService.listSongs().stream().findFirst().orElse(null);
        context.setVariable("selectedSong", s);
        springTemplateEngine.process("songDetails.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long trackId = Long.valueOf(req.getParameter("trackId"));
        String artistId = req.getParameter("artistId");
        Song s = songService.listSongs().stream().findFirst().orElse(null);

        if (trackId != null && artistId != null) {
            s = songService.findByTrackId(trackId);
            Artist a = artistService.ArtistfindById(Long.valueOf(artistId));
            s.addPerformer(a);
        }

        IWebExchange iWebExchange = JakartaServletWebApplication
                .buildApplication(req.getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(iWebExchange);
        context.setVariable("selectedSong", s);
        springTemplateEngine.process("songDetails.html", context, resp.getWriter());

    }
}
