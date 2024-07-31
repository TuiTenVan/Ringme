import { Route, Routes } from "react-router-dom";
import TopBar from "../TopBar/TopBar";
import "./home.css"
import Footer from "../Footer/footer";

function Home() {
  return (
    <>
      <TopBar />
        <Routes>
            <Route path="/home" element={<Home />} />
        </Routes>
      <Footer />
    </>
  );
}

export default Home;
