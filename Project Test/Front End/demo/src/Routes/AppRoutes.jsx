import { Route, Routes } from "react-router-dom"
import Login from "../components/Login"
import Register from "../components/register"
import HomeAdmin from "../components/Admin/Home/HomeAdmin"
import Home from "../components/Web/Home/home"
// import PrivateRoute from "./PrivateRoute"

function AppRoutes(){
    return(
        <>
            <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register/>} />
                <Route path="/*" element={<HomeAdmin />} />
                <Route path="/" element={<Home />} />
                {/* <PrivateRoute>
                    <HomeAdmin/>
                </PrivateRoute> */}
            </Routes>
        </>
    )
}
export default AppRoutes