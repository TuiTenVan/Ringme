import { get, put } from "../utils/request"
const prefixAuth = "api/admin/accounts";

export const getListStaff = async () => {
  const result = await get(`${prefixAuth}/pending`);
  return result;
}; 

export const approveStatus = async (id, options) => {
  try {
    const result = await put(`${prefixAuth}/approve/${id}`, options);
    console.log("Response from approveStatus:", result); // Thêm log để kiểm tra dữ liệu phản hồi từ máy chủ
    return result;
  } catch (error) {
    console.error("Error in approveStatus:", error);
    throw error;
  }
};
